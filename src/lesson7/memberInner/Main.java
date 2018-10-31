package lesson7.memberInner;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        Iterator  iterator = myArray.evenIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
