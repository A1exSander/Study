package daoPackage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao {

    TaskConnection connection = new TaskConnection();

    private void createUserTable(){
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
            connection.updateTable("INSERT INTO User (id, login) VALUES ("+user.getId() + ", " + user.getLogin() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public List<?> getAll() {
        return null;
    }

    @Override
    public Object getById() {
        return null;
    }
}
