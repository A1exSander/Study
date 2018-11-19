package lesson13;

import java.util.Arrays;

enum Stuff {
    ADMIN, USER, GUEST, MODERATOR
}

public class EnumExample {
    public static void main(String[] args) {
        Stuff stuff = Stuff.ADMIN;
        User user = new User(1, "Max", Stuff.ADMIN);
        User user2 = new User(2, "Jimmy", stuff);
        System.out.println(user);

        System.out.println(Arrays.toString(stuff.values()));
//      values
        for (Stuff stuff2: Stuff.values()) {
            System.out.println(stuff2);
            System.out.println(stuff2.ordinal());
        }
//      valueOf();
        String str = "USER";
        Stuff userStuff = Stuff.valueOf(str);
        User user3 = new User(3, "Sarah", userStuff);
        System.out.println(user3);
    }
}

class User {
    private int id;
    private String name;
    private Stuff stuff;

    public User(int id, String name, Stuff stuff) {
        this.id = id;
        this.name = name;
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stuff=" + stuff +
                '}';
    }
}
