package lesson7.book;

import java.util.Objects;


public class Book {
    final static private String CONST1;
    // Константы пишутся большими буквами, слова разделяются нижним_подчеркиванием
    // Значения им могут быть присвоены либо при объявлении, либо в конструкторе при инициализации объекта
    public static int soldBook;

    // статические объекты и методы принадлежат всему классу
    static {
        soldBook = 12;
    }

    static {
        CONST1="Value";
    }

//final переменные - константы
    final String CONST ="String";
    private String title;
    private String author;
    // Статический блок. Выполняется только однаджы и результат сохранятеся в памяти
    private int pages;
    private int soldBook1;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        soldBook1=12;
    }

    public static String getStatistics(){

        return"Book sold: " + soldBook;
    }

    public void sellBook(){
        soldBook++;
        soldBook1++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //Все классы наследуются от класса Object
    // toString()

    public int getPages() {
        return pages;
    }

    // clone() - возвращает копию объекта

    // getClass() - возвращает ссылку на класс объекта

    // finalize() - Метод выполняется, когда объект уничтожается сборщиком мусора

    // Многопоточность:
    // wait() | notify() | notifyAll()

    // equals() - сравнение объектов
    // hashCode() - возвращает hash-код объекта (номер)

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    //По умолчанию сравнивает только на ту же позицию объекта в памяти. При оверрайде сравнивает поля
    //final {метод} не дает переопределить метод (не удастся сделать @override)
    //final {класс} не даст создать наследников. Т.е. дочерних классов, расширяющих возможности этого, уже быть не может

    public String getSoldBook1() {
        return "Book soldBook1: " + soldBook1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }
}
