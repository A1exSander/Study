package lesson4Homework.task2;

class LinkedList {
    private Node head;
    private Node tail;
    private int index=0;

    void add (int value){
        Node a = new Node();
        a.value = value;
        if (tail == null){
            head = a;
            tail = a;
            tail.index = 0;

        } else {
            tail.next = a;
            tail.next.index=tail.index+1;
            tail = a;
        }
    }

    void printList() {
        Node t = head;
        while (t != null) {
            System.out.println(t.index + ": " + t.value);
            t=t.next;
        }
    }

    void delete(int index) {
        if(head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.index == index) {
            head = head.next;
            return;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.index == index) {
                if(tail == t.next)
                {
                    tail = t;
                }
                t.next = t.next.next;
                t.next.index--;
                return;
            }
            t = t.next;
        }
    }

    void find(int index) {
        Node t = head;
        while (t.next != null) {
            if (t.next.index == index) {
                System.out.println(t.next.index + ": " + t.next.value);
                return;
            }
            t = t.next;
        }
    }
}
