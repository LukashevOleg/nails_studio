package ru.vsu.Lukashev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionOnly {
    public static Connection getConnection() throws SQLException {
        String user = "postgres";
        String password = "111";
        String url = "jdbc:postgresql://localhost:1503/Nails";

        System.out.println("successfully connect");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            System.out.println("до вызова Евы");
//            while (resultSet.next()) {
//                System.out.println("Hi, I'm " + resultSet.getString(2));
//            }
        return DriverManager.getConnection(url, user, password);
//            repository = new StatisticRepositoryImpl(connection);


    }
}
