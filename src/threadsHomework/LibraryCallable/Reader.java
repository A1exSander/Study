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
            try {
                library.showLib();
                System.out.println("Введите номер книги, которую хотите забрать");
                int index = scanner.nextInt();
                System.out.println("Введите количество книг, которые хотите забрать");
                quantity = scanner.nextInt();
                System.out.println("Вы хотите забрать домой? (true/false)");
                takeHome = scanner.nextBoolean();
                int q = 0;
                boolean flag = false;


                for (Book book : library.getLib().keySet()) {
                    if (index == book.getIndex()) {
                        if (takeHome && book.getPermissionStatus()) {
                            q = library.takeBook(book, quantity, takeHome);
                            if (q > 0) takenHome.put(book, q);

                        } else if (takeHome && !book.getPermissionStatus()) {
                            System.out.println("Книгу нельзя взять домой");
                        } else {
                            q = library.takeBook(book, quantity, takeHome);
                            if (q > 0) takenLib.put(book, q);

                        }
                        flag = true;
                    }

                }
                if (!flag) System.out.println("Этой книги нет в библиотеке");


                System.out.println("Хотите взять еще одну книгу? (true/false)");
                boolean more = scanner.nextBoolean();
                if (!more) {
                    break;
                } else {
                    System.out.println("Хорошо");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверные данные");
                return;
            }
        }

        System.out.println("Книги, взятые домой:");
        for (Map.Entry entry: takenHome.entrySet()) {
            System.out.println (entry);
        }

        System.out.println("Книги, взятые в читальный зал:");
        for (Map.Entry entry: takenLib.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("Хотите вернуть книги?");

        boolean returnBook = scanner.nextBoolean();
        if (returnBook) {
            while (true) {
                try {
                    System.out.println("Введите индекс книги, которую хотите вернуть");
                    int index = scanner.nextInt();
                    System.out.println("Сколько экземпляров возвращаете?");
                    quantity = scanner.nextInt();

                    for (Map.Entry entry : takenLib.entrySet()) {
                        Book book = (Book) entry.getKey();
                        if (book.getIndex() == index) {
                            if (quantity <= (Integer) entry.getValue() && quantity > 0) {
                                library.returnBooks(book, quantity);
                            } else
                                System.out.println("У вас нет столько экземпляров этой книги или вы указали число меньше единицы");
                        }
                    }

                    for (Map.Entry entry : takenHome.entrySet()) {
                        Book book = (Book) entry.getKey();
                        if (book.getIndex() == index) {
                            if (quantity <= (Integer) entry.getValue() && quantity > 0) {
                                library.returnBooks(book, quantity);
                            } else
                                System.out.println("У вас нет столько экземпляров этой книги или вы указали число меньше единицы");
                        }
                    }


                    System.out.println("Хотите вернуть еще одну книгу?");

                    boolean more = scanner.nextBoolean();
                    if (!more) {
                        break;
                    } else {
                        System.out.println("Хорошо");
                        System.out.println();
                    }
                } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверные данные");
                return;
                }
            }
        }
        System.out.println("Всего хорошего, " + name + ". Заходите еще.");

        library.showLib();

    }
}
