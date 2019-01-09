package threadsHomework.LibraryCallable;

import java.util.*;

public class Reader implements Runnable {
    private String name;
    private Library library;
    private Map<Book, Integer> takenHome = new HashMap<>();
    private Map<Book, Integer> takenLib = new HashMap<>();


    public Reader(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public void run() {
        Boolean takeHome;
        int quantity;
        System.out.println("Добро пожаловать в библиотеку, " + name);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            library.showLib();
            System.out.println("Введите номер книги, которую хотите забрать");
            int index = scanner.nextInt();
            System.out.println("Введите количество книг, которые хотите забрать");
            quantity = scanner.nextInt();
            System.out.println("Вы хотите забрать домой? (true/false)");
            takeHome = scanner.nextBoolean();




            for (Book book : library.getLib().keySet()) {
                   if (index == book.getIndex()) {
                       if (takeHome && book.getPermissionStatus()) {
                           takenHome.put(book, quantity);
                           library.takeBook(book, quantity, takeHome);
                       }
                       else if (takeHome && !book.getPermissionStatus()) {
                           System.out.println("Книгу нельзя взять домой");
                       }
                       else {
                           takenLib.put(book, quantity);
                           library.takeBook(book, quantity, takeHome);
                       }

               }
            }

            System.out.println("Хотите взять еще одну книгу? (true/false)");
            boolean more = scanner.nextBoolean();
            if (!more) {
                break;
            } else {
                System.out.println("Видимо, хотите еще");
            }
        }

        System.out.println("Книги, взятые домой:");
        for (Map.Entry entry: takenHome.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("Книги, взятые в читальный зал:");
        for (Map.Entry entry: takenLib.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("Хотите вернуть книги?");

        boolean returnBook = scanner.nextBoolean();
        if (returnBook) {
            library.returnBooks(takenHome, takenLib);

//            while (true) {
//                System.out.println("Введите индекс книги, которую хотите вернуть");
//                int index = scanner.nextInt();
//                System.out.println("Сколько экземпляров возвращаете?");
//                quantity = scanner.nextInt();
//
//
//                System.out.println("Хотите вернуть еще одну книгу?");
//                if (scanner.nextLine().toLowerCase().equals("да")) {
//                } else if (scanner.nextLine().toLowerCase().equals("нет")) {
//                    break;
//                } else {
//                    System.out.println("Видимо, это значит нет");
//                    break;
//                }
//            }
        }
        System.out.println("Всего хорошего, " + name + ". Заходите еще.");

        library.showLib();

    }
}
