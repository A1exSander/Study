package daoPackage;

import org.sqlite.JDBC;
import java.sql.*;


public class TaskConnection {


    protected void createTable(String create) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        try(Connection connection =
                    DriverManager.getConnection("jdbc:sqlite:task.db")) {

            Statement statement = connection.createStatement();
            System.out.println(statement.executeUpdate(create));
        }


    }

    protected void updateTable(String update) throws SQLException {
        DriverManager.registerDriver(new JDBC());

        try(Connection connection =
                DriverManager.getConnection("jdbc:sqlite:task.db")) {
            Statement statement = connection.createStatement();
            System.out.println(statement.executeUpdate(update));
        }
    }

    protected Object querryTable(String querry) throws SQLException {
        DriverManager.registerDriver(new JDBC());

        try(Connection connection =
                    DriverManager.getConnection("jdbc:sqlite:task.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);
            Object object = resultSet;
            return object;
        }
    }
}
