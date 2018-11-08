package lesson8;


import org.sqlite.JDBC;

import java.sql.*;

public class JDBCExample {
    // Создать таблицу

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Example (" + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "firstColumn TEXT NOT NULL," +
                "secondColumn INTEGER NOT NULL);";
        //TEXT - для текстовой информации
        //REAL - для чисел с плавающей точкой
        //INTEGER - целые числа
        //BLOB - что угодно
        //NUMERIC - ?

        // регистрация драйвера
        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // executeUpdate - создание/обновление/удаление
            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк

        }
    }

    // Вставить данные в таблицу

    public static void insertIntoTable() throws SQLException {
        String sql = "INSERT INTO Example (firstColumn, secondColumn) " +
        "VALUES ('Value1', 123);";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // executeUpdate - создание/обновление/удаление
            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк

        }
    }

    // Получить данный из таблицы

    public static void selectData() throws SQLException {
        String sql = "SELECT * FROM Example;";
                // * - поиск по всей колонке, или используются названия колонок
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            // executeUpdate - создание/обновление/удаление
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String str = resultSet.getString("firstColumn");
                int i = resultSet.getInt("secondColumn");
                System.out.println("str = " + str);
                System.out.println("i = " + i);
            }
        }
    }
    public static void main(String[] args) {
        try {
//            JDBCExample.createTable();
//            JDBCExample.insertIntoTable();
            JDBCExample.selectData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
