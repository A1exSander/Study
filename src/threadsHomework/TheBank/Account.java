package threadsHomework.TheBank;

public class Account {
    private static int accCount = 0;
    private int id;
    private User user;
    private int money;

    public Account(User user, int money) {
        this.id = ++accCount;
        this.user = user;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", money=" + money +
                '}';
    }
}
