package lesson17.patterns.singleton;

public class Singleton1 {

    private static Singleton1 instance;

    // Шаблон "Одиночка".
    // 1. Запретить создание объектов извне (вне класса)
    private Singleton1(){}
    // Метод по созданию объекта. Если его еще нет - он будет создан, иначе будет возвращаться указатель на него
    // Создание объекта по требованию
    public static Singleton1 getInstance(){
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
