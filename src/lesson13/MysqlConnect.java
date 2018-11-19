package lesson13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {
    String connectUrl = "jdbc:mysql://localhost:3306/dbname"; // путь до базы данных
    String user = "root"; // имя пользователя
    String password = "pwd"; // пароль

    public static void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Example (" + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "firstColumn TEXT NOT NULL," +
                "secondColumn INTEGER NOT NULL);";
//        //TEXT - для текстовой информации
//        //REAL - для чисел с плавающей точкой
//        //INTEGER - целые числа
//        //BLOB - что угодно
//        //NUMERIC - ?
//
//        // регистрация драйвера
//        DriverManager.registerDriver(new JDBC());
//
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
//            Statement statement = connection.createStatement();
//            int row = statement.executeUpdate(sql);
//            // executeUpdate - создание/обновление/удаление
//            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // executeUpdate - создание/обновление/удаление
            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTable();

        // create database DBNAME; - создать базу в консоли
    }
}
