package threadsHomework.LibraryCallable;

public class Book {
    private String author;
    private String name;
    private boolean takeHomePermission;
    private int index;

    public Book(int index, String author, String name, boolean takeHomePermission) {
        this.index = index;
        this.author = author;
        this.name = name;
        this.takeHomePermission = takeHomePermission;
    }


    @Override
    public String toString() {
        return index +
                ": [Автор: '" + author + '\'' +
                ", Название: '" + name + '\'' +
                ", Можно взять домой: " + takeHomePermission + "]";
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean getPermissionStatus() {
        return takeHomePermission;
    }
}
