package lesson19.reflectionAPI;

import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        каждый  загруженный класс имеет соответствующий
//        java.lang.Class объект, который дает доступ к структуре класса

//        У каждого типа есть свой литерал class
        System.out.println(String.class);
        System.out.println(int.class);

        Child child = new Child("Вася", 1);

//        Строковой литерал объекта
        System.out.println(child.getClass());
//        Строковой литерал класса наследника

        Class cls;

        cls = child.getClass();
        System.out.println("child name " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("child extends " + cls.getName());

//        Доступ к компонентам

//        Класс объекта
        Class<Child> childClass = Child.class;

//        Доступ к полям
        Field[] fields = childClass.getFields();
        System.out.println(Arrays.toString(fields));
//        Выше - все неприватные поля
        Field[] declaredFields = childClass.getDeclaredFields();
//        Доступ ко всем объявленным полям
        System.out.println(Arrays.toString(declaredFields));

//        Доступ к методам
        Method[] methods = childClass.getMethods();
//        Неприватные методы, включая методы родителя
        System.out.println(Arrays.toString(methods));
//        Только объявленные в классе методы
        Method[] declaredMethods = childClass.getDeclaredMethods();
        System.out.println((Arrays.toString(declaredMethods)));

//        Доступ к конструкторам
        Constructor<?>[] declaredConstructors = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

//        Доступ к конкретному полю, методу, конструктору

//        Доступ к полю
        Field field = childClass.getDeclaredField("name");
//        Указатель на приватное поле name - можем с ним чудить
        field.setAccessible(true);
//        Получили доступ к полю
        field.set(child, "CHILD");
        System.out.println((String) field.get(child));
        System.out.println(child);

//        Доступ к методу
        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);

//        Доступ к конструктору
        Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, int.class);
//        Создание объекта
        Child child1 = childConstructor.newInstance("Петя", 2);
        System.out.println(child1);
        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());

//        Получение интерфейсов, реазованных данным классом
        Class<?>[] interfaces = childClass.getInterfaces();
    }
}
