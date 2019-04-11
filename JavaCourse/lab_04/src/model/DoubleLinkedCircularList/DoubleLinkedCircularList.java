package model.DoubleLinkedCircularList;

public class DoubleLinkedCircularList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T obj){
        if (this.size == 0) {
            this.head = new Node<T>(obj);
            this.head.next = this.head;
            this.head.prev = this.head;
            this.tail = this.head;
        } else {
            Node<T> temp = new Node<>(obj);
            temp.next = this.head;
            temp.prev = this.tail;
            this.head.prev = temp;
            this.tail.next = temp;
            this.head = temp;
        }

        this.size++;
    }

    public void addLast(T obj){
        if (this.size == 0) {
            this.head = new Node<T>(obj);
            this.head.next = this.head;
            this.head.prev = this.head;
            this.tail = this.head;
        } else {
            Node<T> temp = new Node<>(obj);
            temp.next = this.head;
            temp.prev = this.tail;
            this.head.prev = temp;
            this.tail.next = temp;
            this.tail = temp;
        }

        this.size++;
    }

    public void addAt(int index, T obj){
        if (index == 0) this.addFirst(obj);
        if (index == this.size) this.addLast(obj);
        else {
            Node<T> nextNode = this.head;
            for(int i = 0; i < index; i++) nextNode = nextNode.next;
            Node<T> prevNode = nextNode.prev;

            Node<T> currNode = new Node<>(obj);

            prevNode.next = currNode;
            currNode.prev = prevNode;
            currNode.next = nextNode;
            nextNode.prev = currNode;

            this.size++;
        }
    }

    public void moveRight(int steps){
        for (int i = 0; i < steps; i++){
            this.head = this.head.prev;
            this.tail = this.tail.prev;
        }
    }

    public void moveLeft(int steps){
        for (int i = 0; i < steps; i++){
            this.head = this.head.next;
            this.tail = this.tail.next;
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append('[');

        Node<T> current = this.head;
        for(int i = 0; i < this.size; i++){
            result.append(current.value);
            result.append(i != this.size - 1 ? ", " : "");
            current = current.next;
        }

        result.append(']');

        return result.toString();
    }
}
