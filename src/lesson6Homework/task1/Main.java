package lesson6Homework.task1;

//Задание 1
//
//        Реализовать односвязный (или двусвязный) список.
//        Класс Связного списка должен реализовать следующие интерфейсы:
//        List и его методы:
//        add(Object obj, int index); - добавляет объект на указанную позицию (index)
//        remove(int index); - удаляет элемент с указанной позиции (index)
//        get(int index); - находит и возвращает элемент по индексу (index)
//        int size(); - возвращает размер списка
//
//        Stack и его методы:
//        push(Object obj); - добавляет объект в конец списка
//        pop(); - удаляет элемент из конца списка
//
//        Queue и его методы:
//        shift(Object obj); - добавляет объект в начало списка
//        unshift(); - удаляет элемент из начала списка

public class Main {
    public static void main(String[] args) {
        Node temp = new Node(0);
        Node temp2 = new Node(1);
        Node temp3 = new Node(2);
        Node temp4 = new Node(3);
        Node temp5 = new Node(4);
        Node temp6 = new Node(5);
        Node temp7 = new Node(6);
        LinkedList linkedlist = new LinkedList();
        linkedlist.push(temp);
        linkedlist.push(temp2);
        linkedlist.push(temp3);
        linkedlist.shift(temp4);
        linkedlist.shift(temp5);
        linkedlist.printList();
//        linkedlist.unshift();
//        linkedlist.printList();
//        System.out.println();
//        linkedlist.pop();
//        linkedlist.printList();
//        System.out.println();
//        linkedlist.shift(temp4);
//        linkedlist.printList();
        System.out.println();
        System.out.println(linkedlist.get(0).toString());
        System.out.println(linkedlist.size());
        System.out.println();
        linkedlist.remove(3);
        linkedlist.printList();
        System.out.println();
        linkedlist.add(temp6, 1);
        linkedlist.printList();
    }
}
