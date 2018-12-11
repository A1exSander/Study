package lesson19.annotations;


// данный класс дольны использовать объекты с User.Permission.ADMIN
// Использование
@PermissionRequired(User.Permission.ADMIN)
public class DeleteAction {
    public void delete (User user) {
        System.out.println("del user");
    }
}
