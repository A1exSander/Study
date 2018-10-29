package lesson6;

public interface ISpeakerUnit {
//    int health = 23; Все переменные должны быть константами, если речь идет об интерфейсе
//  Если нужен метод приватный, то с Java 9 можно использовать модификатор private

    void say(String text);
    void sing(String song);

    default void greeting(){
        // default метод с реализацией (начиная от Java 8)
        System.out.println("Hello!");
    }


}
