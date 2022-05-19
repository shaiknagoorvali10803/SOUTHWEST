package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url = "jdbc:h2:mem:";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }
}
