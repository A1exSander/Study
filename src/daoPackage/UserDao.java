package daoPackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao {

    TaskConnection connection = new TaskConnection();

    protected void createUserTable(){
        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "login TEXT NOT NULL);";
        try {
            connection.createTable(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add(Object object){
        try {
            User user = (User) object;
            connection.updateTable("INSERT INTO User (id, login) VALUES ("+user.getId() + ", '" + user.getLogin() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {
        User user = new User();
        try {
            connection.updateTable("UPDATE User SET login='"+user.getLogin()+" WHERE id=" + user.getId() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<?> getAll() {

        {
            List<User> list = new ArrayList<>();
            ResultSet resultSet;
            try {
                resultSet = (ResultSet) connection.querryTable("SELECT * FROM User;");
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login"));
                    list.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return list;
        }
    }

    @Override
    public Object getById(int id) {
        User user = new User();
        ResultSet resultSet;
        try {
            resultSet = (ResultSet) connection.querryTable("SELECT * FROM User WHERE id=" + id + ";");
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
