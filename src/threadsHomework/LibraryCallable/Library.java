package threadsHomework.LibraryCallable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class Library {
    ConcurrentHashMap<Book, Integer> lib;

    Library() {
        lib = new ConcurrentHashMap<>();
    }

    void addBook(Book book, Integer quantity){
        if (lib.containsKey(book)) {
            int q = lib.get(book);
            q = q + quantity;
            lib.put(book, q);
        } else lib.putIfAbsent(book, quantity);
    }

    int takeBook(Book book, Integer quantity, boolean takingHome) {
        if (takingHome == book.getPermissionStatus() || !takingHome) {
            if (lib.containsKey(book) && lib.get(book) > 0 && lib.get(book) - quantity >= 0) {
                int q = lib.get(book);
                if (lib.get(book) - quantity == 0) {
                    lib.remove(book);
                    System.out.println("Взято " + quantity + " экземпляров книги " + book.toString());
                    System.out.println("Экземпляров этой книги в библиотеке больше нет");
                    return quantity;
                } else {
                    lib.put(book, q - quantity);
                    System.out.println("Взято " + quantity + " экземпляров книги " + book.toString());
                    return quantity;
                }
            } else {
                System.out.println("Этой книги нет в библиотеке или запрошенное количество превышает имеющееся в наличии");
                return 0;
            }

        } else System.out.println("Эту книгу нельзя забрать домой");
        return 0;
    }

    void returnBooks(Book book, int quantity) {
        if (lib.containsKey(book)) lib.merge(book, quantity, (oldVal, newVal) -> oldVal + newVal);
        else lib.put(book, quantity);
    }

    ConcurrentMap<Book, Integer> getLib(){
        return lib;
    }



    void showLib(){
        for (ConcurrentMap.Entry entry: lib.entrySet()) {
            System.out.println(entry);
        }
    }
}
