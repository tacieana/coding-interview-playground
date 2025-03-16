package theoryexamples;

import model.Node;

public class BinarySearchTreeOperation {

    public Node<Integer> insert(Node<Integer> node, Integer value) {
        if (node == null) return new Node(value);

        if(value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    public Node<Integer> delete(Node<Integer> node, Integer value) {
        if (node == null) return null;

        if(value < node.getValue()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if(value > node.getValue()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setValue(getMaxValue(node.getLeft()));
            node.setLeft(delete(node.getLeft(), node.getValue()));
        }

        return node;
    }

    private Integer getMaxValue(Node<Integer> node) {
        if(node.getRight() == null) return node.getValue();
        return getMaxValue(node.getRight());
    }

    public static void main(String args[]) {

        Node<Integer> root = new Node(4);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n6 = new Node(6);
        Node<Integer> n1 = new Node(1);
        Node<Integer> n3 = new Node(3);
        Node<Integer> n5 = new Node(5);
        Node<Integer> n7 = new Node(7);
        n6.setLeft(n5);
        n6.setRight(n7);
        n2.setLeft(n1);
        n2.setRight(n3);
        root.setLeft(n2);
        root.setRight(n6);

        BinarySearchTreeOperation operations = new BinarySearchTreeOperation();

        //root = operations.insert(root, 8);
        root = operations.delete(root, 4);
        System.out.println(root);
    }
}
