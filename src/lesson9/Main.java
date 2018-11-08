package lesson9;

import lesson9.classes.Book;
import lesson9.classes.Car;
import lesson9.classes.ChildBook;
import lesson9.storage.Storage;

public class Main {

    public static void main(String[] args) {
        Book tails = new Book("Сказки", 500);
        Book flowers = new Book("Цветы", 600);

        Car car = new Car("green", 1000);

        Storage<Book> bookStorage = new Storage<>();
        bookStorage.add(tails);
        bookStorage.add(flowers);
        //bookStorage.add(car);

        // ClassCastException возникает на моменте исполнения
        Book bookFromStorage =  bookStorage.get(1);
        System.out.println(bookFromStorage);
//
        Storage<ChildBook> childBookStorage = new Storage<>();
        ChildBook bears = new ChildBook("Маша и Медведи", 200, "pic");
        ChildBook coloring = new ChildBook("Coloring", 100, "pic");
        childBookStorage.add(bears);

        // Book firstBook = getFirstBook(bookStorage);
        // Book firstBook = getFirstBook(childBookStorage);
        Book firstBook = getFirstBook(childBookStorage);

    }

//    public static Book getFirstBook(Storage<Book> storage){ - не сработает без уточнения
//        return storage.get(0);
//    }
    //extends
    public static Book getFirstBook(Storage<? extends Book> storage){ // Только для получения элементов. Добавить через класс с extends нельзя, включая дочерние классы
        return storage.get(0);
    }

    // super
    public static void addToStorage(Storage<? super Book> storage){ // Только для записи
        Book book = new Book("book", 10);
        storage.add(book);

//        Book b = storage.get(0); //- получить ничего нельзя при таком уточнении
        Object b = storage.get(0);  // Так можно найти объект, но он не будет объектом класса
        System.out.println(b);
    }

//    public void someVoid(Storage<String> storage) {} // Так не сработает. Компилятор уберет дженерики в такой ситуации
//    public void someVoid(Storage<Integer> storage) {}
//    T someType = new T(); - так создать объект нельз
//    Также нельзя работать со статикой:
//    public static T staticVoid(){}


//    public static void addToStorage(Storage<?> storage){ // Только для записи
//        Book book = new Book("book", 10);
//        storage.add(null);
//
//        Book b1 = storage.get(0);
//        Object b = storage.get(0);
//        System.out.println(b);
//    }

}