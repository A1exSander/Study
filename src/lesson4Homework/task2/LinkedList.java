package lesson4Homework.task2;

class LinkedList {
    private Node head;
    private Node tail;
    private int index=0;

    void add (int value){
        Node a = new Node();
        a.value = value;
        a.index = index;
        if (tail == null){
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
        index++;
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
                return;
            }
            t = t.next;
        }
    }
}
