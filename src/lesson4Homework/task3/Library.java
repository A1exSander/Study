package lesson4Homework.task3;

public class Library {
    int spaceMax, counter=0;
    private int resSpace=0;
    Book[] lib;

    public Library(int spaceMax) {
        this.spaceMax = spaceMax;
        Book[] lib = new Book[spaceMax];
        this.lib=lib;
    }

    void put (Book book, int quantity){
        if (resSpace<spaceMax){
            counter = quantity;
            for (int i=0; i<spaceMax; i++) {
                if (lib[i] == null && counter>0) {
                    lib[i] = book;
                    lib[i].index = i;
                    resSpace++;
                    counter--;
                    if (resSpace == spaceMax){
                        System.out.println("Место закончилось. Внесено " + (quantity-counter) + " экземпляров книги" + book.author + " " + book.name);
                        break;
                    }
                }

            }
            if (counter==0) System.out.println("Внесено " + quantity + " экземпляров книги " + book.author + " " + book.name);

        }
        else System.out.println("Не хватает места");
        System.out.println("Занято места: " + resSpace);
    }

    void get (Book book, int quantity){
        counter=quantity;
        for (int i=0; i<spaceMax; i++){
            if (counter == 0) {
                System.out.println("Изъято " + quantity + " экземпляров книги " + book.author + " " + book.name);
                break;
            }
            if (book.equals(lib[i])) {
                counter--;
                lib[i] = null;
                resSpace--;
            }
        }
        if (counter>0) {
            quantity = quantity - counter;
            if (quantity == 0) System.out.println("Книги " + book.author + " " + book.name + " в библиотеке нет");
            else {
                System.out.println("Изъято " + quantity + " экземпляров книги " + book.author + " " + book.name);
                System.out.println("Больше в библиотеке нет");
            }
        }
    }
}
