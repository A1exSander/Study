package lesson4Homework.task2;

public class LinkedList {
    private Node head;
    private Node tail;

    void add (int value){
        Node a = new Node();
        a.value = value;
        if (head == null){
            head = a;
            tail = a;
        } else {
           a.next = head;
           head = a;
        }
    }

    void printList() {
        Node t = new Node();
        while (t != null) {
            System.out.println(t.value + " ");
            t=t.next;
        }
    }

    void delete(int value) {
        if(head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.value == value) {
                if(tail == t.next)
                {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }

}
