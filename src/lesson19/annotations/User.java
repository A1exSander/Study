package lesson19.annotations;

public class User {
    private Permission permission;

    public User(Permission permission) {
        this.permission = permission;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public static enum Permission {
        USER, ADMIN
    }
}
