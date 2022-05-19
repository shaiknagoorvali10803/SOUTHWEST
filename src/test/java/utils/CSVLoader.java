package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Date;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
public class CSVLoader {
    private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
    private static final String TABLE_REGEX = "\\$\\{table\\}";
    private static final String KEYS_REGEX = "\\$\\{keys\\}";
    private static final String VALUES_REGEX = "\\$\\{values\\}";

    private final Connection connection;
    private char seprator;

    public CSVLoader(Connection connection) {
        this.connection = connection;
        this.seprator = ',';
    }

    public void loadCSV(String csvFile, String tableName, boolean truncateBeforeLoad) throws Exception {
        CSVReader csvReader = null;
        if (null == this.connection) {
            throw new Exception("Not a valid connection.");
        }
        try {
            csvReader = new CSVReader(new FileReader(csvFile), this.seprator);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error occured while executing file. " + e.getMessage());
        }

        String[] headerRow = csvReader.readNext();
        if (null == headerRow) {
            throw new FileNotFoundException("No columns defined in given CSV file." + "Please check the CSV file format.");
        }

        String questionmarks = StringUtils.repeat("?,", headerRow.length);
        questionmarks = (String) questionmarks.subSequence(0, questionmarks.length() - 1);

        String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
        query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
        query = query.replaceFirst(VALUES_REGEX, questionmarks);

        System.out.println("Query: " + query);
        
        //

        String[] nextLine;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = this.connection;
            Statement statement = con.createStatement();
            //String tableCheck = String.format("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE '%s'", tableName);
            //ResultSet rs = statement.executeQuery(tableCheck);
            //boolean isThere = rs.first();
            String createQuery = String.format("CREATE TABLE %s(id INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255), password VARCHAR(255), cid VARCHAR(255), comName VARCHAR(255), ARCNumber VARCHAR(255), TravelAgency VARCHAR(255), AccountType VARCHAR(255),Name VARCHAR(255), contactNameList VARCHAR(255), contactEmail VARCHAR(255), contactPhone VARCHAR(255),contactRole VARCHAR(255), secondaryAccount VARCHAR(255));", tableName);
            statement.execute(createQuery);
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);

            if (truncateBeforeLoad) {
                //delete data from table before loading csv
                con.createStatement().execute("DELETE FROM " + tableName);
            }

            final int batchSize = 1000;
            int count = 0;
            Date date = null;
            while ((nextLine = csvReader.readNext()) != null) {
                int index = 1;
                for (String s : nextLine) {
                    ps.setString(index++, s);
                }
                ps.addBatch();
                if (++count % batchSize == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch(); // insert remaining records
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new Exception("Error occured while loading data from file to database." + e.getMessage());
        } finally {
            if (null != ps) {
                ps.close();
            }
            csvReader.close();
        }
    }

    public char getSeprator() {
        return seprator;
    }

    public void setSeprator(char seprator) {
        this.seprator = seprator;
    }

}
