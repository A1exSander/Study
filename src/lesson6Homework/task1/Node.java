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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}
