package lesson4Homework.task2;

//2. Реализовать однонаправленный (или двусвязный ) список, с методами add() и remove()

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(14);

        list.delete(3);
        list.delete(7);

        list.add(500);

        list.find(66);

        System.out.println(list.toString());


        list.printList();
        System.out.println();
    }
}
