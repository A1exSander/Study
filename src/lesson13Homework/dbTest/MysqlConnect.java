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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        voidForUsingDB();
    }

}