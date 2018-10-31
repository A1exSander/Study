package lesson6Homework.task1;

public class Node {
int value, index;
Node next;
Node prev;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public Node(Node prev, int value, Node next) {
        this.value = value;
        this.next = next;
        this.prev = prev;


    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}
