package dto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DbResultToCSV {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:";
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("C:\\Users\\x283727\\Documents\\WorkSpace\\qmo-travel-portal\\src\\test\\resources\\Data.csv"));
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE cars(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), price INT);");
            statement.execute("INSERT INTO cars(name, price) VALUES('Audi', 55000)");
            statement.execute("INSERT INTO cars(name, price) VALUES('BMW', 60000)");
            statement.execute("INSERT INTO cars(name, price) VALUES('Tesla', 65000)");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");

            String header = "Id, name, price";
            fileWriter.write(header);

            while (resultSet.next()) {
                String Id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String line = String.format("%s,%s,%s", Id, name, price);
                fileWriter.newLine();
                fileWriter.write(line);
            }
            statement.close();
            fileWriter.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
