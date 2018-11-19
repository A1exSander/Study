package lesson13Homework.dbTest;

import java.sql.*;

public class MysqlConnect {
    // строка для подключения
    static String connectUrl = "jdbc:mysql://localhost:3306/courses?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // строка с именем пльзователя
    static String user = "Shamrock";
    // строка с паролем
    static String password = "USDRUB";


    // все методы будут использовать соединение с бд
    // формирование запросов через statement и prepareStatement смотрите в Lesson8
    public static void voidForUsingDB() throws SQLException, ClassNotFoundException {

        // регистрация драйвера
        Class.forName("com.mysql.cj.jdbc.Driver");
        // открываем соединение
        try (Connection connection =
                     DriverManager.getConnection(connectUrl, user, password)){
            // любые действия с базой
        }
    }
    public static void addTeacher(String name, String surname) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Teacher (name, surname) VALUES('"+name+"', '"+surname+"');";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection =
                     DriverManager.getConnection(connectUrl, user, password)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void addSubject(String title, int duration, int price, int teacher_id) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Subject (title, duration,price,  teacher_id) VALUES('"+title+"',"+duration+","+price+", "+teacher_id+");";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection =
                     DriverManager.getConnection(connectUrl, user, password)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void getMaxSubject() throws SQLException, ClassNotFoundException {

        String sql = "SELECT max(price) FROM Subject;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection =
                     DriverManager.getConnection(connectUrl, user, password)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }

}