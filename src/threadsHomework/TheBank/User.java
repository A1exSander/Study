package threadsHomework.TheBank;

public class User {
    private static int userCount = 0;
    private int id;
    private String email;

    public User(String email) {
        this.id = ++userCount;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
