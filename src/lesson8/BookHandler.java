package lesson8;

import org.sqlite.JDBC;

import java.sql.*;

public class BookHandler {

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Book (" + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT NOT NULL," +
                "pages INTEGER NOT NULL);";

        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // executeUpdate - создание/обновление/удаление
            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк

        }
    }

    public static void insertIntoTable(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, pages) " +
                "VALUES (?, ?);";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());

            int row = statement.executeUpdate();
            // executeUpdate - создание/обновление/удаление
            System.out.println(row); //создание/удаление - 0, изменение - количество измененных строк

        }
    }

    public static Book selectData(int id) throws SQLException {
        String sql = "SELECT * FROM Book WHERE id = ?;";
        // * - поиск по всей колонке, или используются названия колонок
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            PreparedStatement statement = connection.prepareStatement(sql);
            // executeUpdate - создание/обновление/удаление
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Book book = new Book();
            while (resultSet.next()){
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
//                String title = resultSet.getString("title");
//                int pages = resultSet.getInt("pages");
//                System.out.println("title = " + title);
//                System.out.println("pages = " + pages);
            }
            return book;
        }
    }

    public static void main(String[] args) {

        Book book1 = new Book("Азбука", 500);
        Book book2 = new Book("Азбука2", 200);
        Book book3 = new Book("Азбука3", 300);
        try {
//        BookHandler.createTable();
//            BookHandler.insertIntoTable(book1);
            System.out.println(BookHandler.selectData(1).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
