package ru.vsu.Lukashev;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        String user = "postgres";
        String password = "111";
        String url = "jdbc:postgresql://localhost:1503/Nails";
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = String.format("SELECT * FROM \"%s\" WHERE client_id = %d","Clients", 2);
            System.out.println("successfully connect");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("до вызова Евы");
            while (resultSet.next()) {
                System.out.println("Hi, I'm " + resultSet.getString(2));
            }

//            repository = new StatisticRepositoryImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
