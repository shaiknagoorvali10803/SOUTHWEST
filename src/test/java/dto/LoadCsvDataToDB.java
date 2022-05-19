package dto;

import connection.DbConnection;
import utils.CSVLoader;

public class LoadCsvDataToDB {

    public static void load(){
        try {
            CSVLoader loader = new CSVLoader(DbConnection.getConnection());
            loader.loadCSV(System.getenv("inputFile"), System.getenv("tableName"), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
