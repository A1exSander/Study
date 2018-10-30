package lesson4Homework.task3;

public class Library {
    int spaceMax, resSpace=0, counter;

//    public Library(int spaceMax) {
//        this.spaceMax = spaceMax;
//    }
//    Спросить, почему не задается массив заданного размера

    Book[] lib = new Book[spaceMax=30];
    void put (Book book, int quantity){
        if (resSpace<spaceMax){
            for (int i=0; i<quantity; i++) {
                if (lib[i] == null) {
                    lib[i] = book;
                    lib[i].index = i;
                    resSpace++;
                }
            }
            System.out.println("Внесено " + quantity + " экземпляров книги " + book.author + " " + book.name);
        }
        else System.out.println("Не хватает места");
    }

    void get (Book book, int quantity){
        counter=quantity;
        for (int i=0; i<spaceMax; i++){
            if (counter == 0) {
                System.out.println("Изъято " + quantity + " экземпляров книги " + book.author + " " + book.name);
                break;
            }
            if (lib[i] == book) {
                counter--;
                lib[i] = null;
                resSpace--;
            }
        }

    }
}
