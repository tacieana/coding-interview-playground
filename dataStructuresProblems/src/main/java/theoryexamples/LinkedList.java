package theoryexamples;

import model.Node;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            tail.setRight(node);
            node.setLeft(tail);
            tail = node;
        }
    }

    public void addFirst(Node<T> node) {
        node.setRight(head);
        head.setLeft(node);
        head = node;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
