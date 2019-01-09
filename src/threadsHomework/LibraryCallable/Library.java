package threadsHomework.LibraryCallable;

import java.util.Map;
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

    void takeBook(Book book, Integer quantity, boolean takingHome) {
        if (takingHome == book.getPermissionStatus() || !takingHome) {
            if (lib.containsKey(book) && lib.get(book) > 0 && lib.get(book) - quantity >= 0) {
                int q = lib.get(book);
                if (lib.get(book) - quantity == 0) {
                    lib.remove(book);
                    System.out.println("Взято" + quantity + "экземпляров книги " + book.toString());
                    System.out.println("Экземпляров этой книги в библиотеке больше нет");
                } else {
                    lib.put(book, q - quantity);
                    System.out.println("Взято " + quantity + " экземпляров книги " + book.toString());
                }
            } else
                System.out.println("Этой книги нет в библиотеке или запрошенное количество превышает имеющееся в наличии");
        } else System.out.println("Эту книгу нельзя забрать домой");
    }

    void returnBooks(Map<Book, Integer> takenHome, Map<Book, Integer> takenLib) {
        for (Map.Entry entry: takenHome.entrySet()) {
            lib.merge((Book) entry.getKey(),(Integer) entry.getValue(), (oldVal, newVal) -> oldVal + newVal);
        }
        for (Map.Entry entry: takenLib.entrySet()) {
            lib.merge((Book) entry.getKey(),(Integer) entry.getValue(), (oldVal, newVal) -> oldVal + newVal);
        }
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
