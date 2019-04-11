package model.DoubleLinkedCircularList;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node() {
        this.value = null;
    }

    public Node(T value) {
        this.value = value;
    }
}
