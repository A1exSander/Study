package lesson4Homework.task2;

//2. Реализовать однонаправленный (или двусвязный ) список, с методами add() и remove()

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(8);
        list.add(9);

        System.out.println(list.toString());


        list.printList();
        System.out.println();
    }
}
