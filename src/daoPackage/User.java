package daoPackage;

public class User {


    int id;
    String login;

    public User() {
    }

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}

class Article{

    int id;
    String title;
    int idUser;

    public Article() {
    }

    public Article(int id, String title, int idUser) {
        this.id = id;
        this.title = title;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}


