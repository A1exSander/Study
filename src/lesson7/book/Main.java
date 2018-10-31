package lesson7.book;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Война и Мир", "Толстой");
        book1.setPages(1000);

        Book book2 = new Book("Война и Мир", "Толстой");
        book2.setPages(1000);

        System.out.println(book1.toString());
        System.out.println(book2.toString());

        System.out.println(book1 == book2); // false (True только если ссылки с обеих переменных ведут на один и тот же объект)
        System.out.println(book1.equals(book2)); // false

        // add(object obj) {} - можно передавать любые объекты
        System.out.println(Book.getStatistics());
        System.out.println(book1.getSoldBook1());

        book1.sellBook();
        book1.sellBook();

        System.out.println(Book.getStatistics());
        System.out.println(book1.getSoldBook1());

        book2.sellBook();

        System.out.println(Book.getStatistics());
        System.out.println(book1.getSoldBook1());

        //Статические переменные и методы можно использовать без создания объектов типа класса
        //К нестатическими переменным нельзя обращаться из статических методов
        //Вызывать нестатические методы в статических тоже нельзя
        //Класс может быть статическим, но только класс внутри класса. Основной статическим быть не может
    }
}
