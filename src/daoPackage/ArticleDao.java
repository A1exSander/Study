package daoPackage;

import java.sql.SQLException;
import java.util.List;

public class ArticleDao implements Dao {

    TaskConnection connection = new TaskConnection();

    protected void createArticleTable(){
        String sql = "CREATE TABLE IF NOT EXISTS Article (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT NOT NULL," + "idUser INTEGER NOT NULL);";
        try {
            connection.createTable(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Object object) {
        try {
            Article article = (Article) object;
            String s = "Insert into Article (title, idUser) Values (`qw`, 1)";
            connection.updateTable("INSERT INTO Article (id, title, idUser) VALUES ("+article.getId() + ", `" + article.getTitle() + "`, "+ article.getIdUser() + ")");
//            connection.updateTable(s);
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
    public List<?> getAll()
    {
//        List<Article>
        return null;
    }

    @Override
    public Object getById() {
        return null;
    }
}
