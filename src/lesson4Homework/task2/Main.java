package lesson4Homework.task2;

//2. Реализовать однонаправленный (или двусвязный ) список, с методами add() и remove()

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(10);

        list.printList();
        System.out.println();

        list.delete(6);
        list.delete(0);

        list.printList();
        System.out.println();
    }
}
