package threadsHomework.LibraryCallable;

//Библиотека. Доступны для чтения несколько книг. Одинаковых книг в библиотеке нет.
//Некоторые выдаются на руки, некоторые только в читальный зал.
//Читатель может брать на руки и в читальный зал несколько книг.

public class Main {
    public static void main(String[] args) {


        Book book1 = new Book(1,"aaaa", "aaaa", true);
        Book book2 = new Book(2,"bbbb", "bbbb", false);
        Book book3 = new Book(3,"cccc", "ccccc", true);
        Book book4 = new Book(4,"dddd", "ddddd", false);

        Library library = new Library();

        library.addBook(book1, 5);
        library.addBook(book2, 2);
        library.addBook(book3, 6);
        library.addBook(book4, 9);

        Reader reader1 = new Reader("Коля", library);

        new Thread(reader1).start();

    }
}
