package lesson4Homework.task3;

//Сделать библиотеку, которая ведет учет книг. Должно быть как минимум два класса:
// Book и Library. Library имеет два метода: void put(Book book, int quantity) и
// int get(Book book, int quantity). Каждой книге в библиотеке соответствует счетчик,
// показывающий количество хранящихся книг, при добавлении книги - счетчик увеличивается,
// при извлечении - уменьшается на число quantity.
// Библиотека хранит ограниченное число книг, сколько - на ваше усмотрение.

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.author="Ф.М. Достаевский";
        book2.author="А. Сапковский";
        book3.author="А. Рэнд";
        book1.name ="Преступление и наказание";
        book2.name ="Сезон гроз";
        book3.name ="Атлант расправил плечи";

        Library lib = new Library();
        lib.put(book1, 6);
        lib.put(book2, 8);
        lib.put(book3, 10);

        lib.get(book1, 3);
        lib.get(book2, 1);
        lib.get(book3, 4);
    }

}
