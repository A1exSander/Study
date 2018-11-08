package lesson6Homework.task1;

class LinkedList implements List, Queue, Stack {
    private Node head;
    private Node tail;
    private int size=0;

    @Override
    public void add(Node node, int index) {
        if (index>=0 && index<=size) {
            if (index == 0) shift(node);
            else if (index == size) push(node);
            else {
                Node temp = get(index);
                temp.prev.next = node;
                node.prev = temp.prev;
                node.next = temp;
                temp.prev = node;
                size++;
            }
        } else System.out.println("Неверный индекс");
    }

    @Override
    public void remove(int index) {
        if (index>0 && index<=size) {
            Node temp = get(index);
            if (temp == head) head = temp.next;
            if (temp == tail) tail = tail.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp = null;
                size--;

        } else System.out.println("Неверный индекс");

    }
    @Override
    public Node get(int index) {
        if (index>0 && index<size) {
            Node temp = head;
            for (int i = 0; i<index; i++) {
                temp = temp.next;
                temp.index = i+1;
            }
            return temp;
        } else if (index==0) return head;
        else if (index==size-1) return tail;
        else {
            System.out.println("Неверный индекс");
            return null;
        }

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
