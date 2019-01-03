package patternsHomework.logger;

//Самостоятельно изучить паттерн Стратегия. Реализовать Logged.
//1. Интерфейс ILogger с мотодом write()
//2. Реализовать три стратегии:
//ConsoleLogger - выводит сообщения в консоль
//FileLogger - записывает сообщение в файл
//TimeFileLogger - записывает сообщение в файл + текущее время
//3. Реализовать классы, исползующие эти стратегии.
//Запись в файл должна работать!


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение");
        String message;
        message = scanner.nextLine();

        Strategy log1 = new Strategy(new ConsoleLogger());
        Strategy log2 = new Strategy(new FileLogger());
        Strategy log3 = new Strategy(new TimeFileLogger());
        log1.write(message);
        log2.write(message);
        log3.write(message);

    }
}
