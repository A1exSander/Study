package lesson17.patterns.singleton;

public class Singleton2 {

    // Создаем константу с объектом
    private static  final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    // Создание объекта при инициализации класса
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
