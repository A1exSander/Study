package lesson19.annotations;

public class ParseAnnotation {

    public static void main(String[] args) {
        User user = new User(User.Permission.ADMIN);

        Class<?> actionClass = DeleteAction.class;

        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);

        if(permissionRequired != null) {
            if (user.getPermission().equals(permissionRequired.value()))
            {
                System.out.println("Пользователю доступно удаление");
            }
        }
    }

}

// Написать рефлексивный toString

// написать небольшой Dependency Injection Framework
// Всю логику можно собрать в одном классе DIContext, благодаря которому можно создавать
// экземпляр любого класса с автоматически установленными зависимостями
