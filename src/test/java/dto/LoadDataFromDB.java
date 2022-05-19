package dto;

import connection.DbConnection;
import entity.TpTable;
import utils.DBTablePrinter;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoadDataFromDB {
    TpTable table;
    List<TpTable> tableList;

    public List<TpTable> load(String emailUser) {
        tableList = new ArrayList<>();
        try {
            Statement statement = DbConnection.getConnection().createStatement();
            String format = String.format("SELECT * FROM %s where email='%s'", System.getenv("tableName"), emailUser);
            DBTablePrinter.printTable(DbConnection.getConnection(), System.getenv("tableName"));
            ResultSet resultSet = statement.executeQuery(format);
            while (resultSet.next()) {
                String email = Optional.ofNullable(resultSet.getString("email")).orElse("null");
                String password = Optional.ofNullable(resultSet.getString("password")).orElse("null");
                String cid = Optional.ofNullable(resultSet.getString("cid")).orElse("null");
                String companyName = Optional.ofNullable(resultSet.getString("comName")).orElse("null");
                String ArcNumber = Optional.ofNullable(resultSet.getString("ARCNumber")).orElse("null");
                String travelAgency = Optional.ofNullable(resultSet.getString("TravelAgency")).orElse("null");
                String accountType = Optional.ofNullable(resultSet.getString("AccountType")).orElse("null");
                String name = Optional.ofNullable(resultSet.getString("Name")).orElse("null");
                String contactNameList = Optional.ofNullable(resultSet.getString("contactNameList")).orElse("null");
                String contactEmail = Optional.ofNullable(resultSet.getString("contactEmail")).orElse("null");
                String contactPhone = Optional.ofNullable(resultSet.getString("contactPhone")).orElse("null");
                String contactRole = Optional.ofNullable(resultSet.getString("contactRole")).orElse("null");
                String secondaryAccount = Optional.ofNullable(resultSet.getString("secondaryAccount")).orElse("null");
                table = new TpTable(email, password, cid, companyName, ArcNumber, travelAgency, accountType, name, contactNameList, contactEmail, contactPhone, contactRole, secondaryAccount);
                tableList.add(table);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tableList;
    }

    public List<TpTable> getTable() {
        return tableList;
    }

}
