package lesson6Homework.task1;

class LinkedList implements List, Queue, Stack {
    private Node head;
    private Node tail;
    private int size=0;

    @Override
    public void add(Node node, int index) {
        if (index>0 && index<=size) {
            if (index == 0) shift(node);
            else if (index == size) push(node);
            else {


                Node temp = head;
                for (int i = index; i > 0; i--) temp = temp.next;
                temp.prev.next = node;
                node.prev = temp.prev;
                node.next = temp;
                temp.prev = node;
            }
        } else System.out.println("Неверный индекс");
    }

    @Override
    public void remove(int index) {
        if (index>0 && index<=size) {
            Node temp = head;
            for (int i = index; i > 0; i--) temp = temp.next;
            if (temp == head) head = temp.next;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp = null;

        } else System.out.println("Неверный индекс");

    }

    @Override
    public int get(int index) {
        if (index>=0 && index<size) {
        if (size/2 < index) {
            Node temp = head;
            for (int i = 0; i<index; i++) {
                temp = temp.next;
                temp.index = i;
            }
            return temp.index;
        } else {
            Node temp = tail;
            for (int i = size; i >= index; i--) {
                temp = temp.prev;
                temp.index = i;
            }
            return temp.index;
        }
        } else return 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void shift(Node node) {
        node.prev = null;
        node.next = head;
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            Node currFirst = head;
            head = node;
            currFirst.prev = head;
            size++;
        }
    }

    @Override
    public void unshift() {
        head = head.next;
        head.prev = null;
        size--;
    }

    @Override
    public void push(Node node) {
        Node currLast = tail;
        node.prev = tail;
        node.next = null;
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail = node;
            currLast.next = node;
            size++;
        }
    }

    @Override
    public void pop() {
        tail=tail.prev;
        tail.next=null;
        size--;

    }

    void printList() {
        Node t = head;
        int i=0;
        while (i < size) {
            System.out.println(i + ": " + t.value);
            t=t.next;
            i++;
        }
    }

}
