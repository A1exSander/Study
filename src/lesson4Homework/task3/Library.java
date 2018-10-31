package lesson4Homework.task3;

public class Library {
    int spaceMax=50, counter=0;
    private int resSpace=0;

//    public Library(int spaceMax) {
//        this.spaceMax = spaceMax;
//    }
//    Спросить, почему не задается массив заданного размера

    Book[] lib = new Book[spaceMax];
    void put (Book book, int quantity){
        if (resSpace<spaceMax){
            counter = quantity;
            for (int i=0; i<spaceMax; i++) {
                if ((lib[i] == null) && counter>0) {
                    lib[i] = book;
                    lib[i].index = i;
                    resSpace++;
                    counter--;
                    if (resSpace == spaceMax){
                        System.out.println("Место закончилось. Внесено " + (quantity-counter) + " экземпляров книги");
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
        if (counter>0){
            quantity=quantity-counter;
            System.out.println("Изъято " + quantity + " экземпляров книги " + book.author + " " + book.name);
            System.out.println("Больше в библиотеке нет");
        }

    }
}
