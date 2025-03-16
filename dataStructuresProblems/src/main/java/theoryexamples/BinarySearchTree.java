package theoryexamples;

import model.Node;

public class BinarySearchTree {

    public Node<Integer> searchValueRecursive(Node<Integer> root, Integer value) {

        if (root == null) return null;

        if(value == root.getValue()) {
            return root;
        } else if(value < root.getValue()) {
            return searchValueRecursive(root.getLeft(), value);
        }
        return searchValueRecursive(root.getRight(), value);
    }

    public static void main(String args[]) {
        Node<Integer> n0 = new Node(4);
        Node<Integer> n1 = new Node(2);
        Node<Integer> n2 = new Node(6);
        Node<Integer> n3 = new Node(1);
        Node<Integer> n4 = new Node(3);
        Node<Integer> n5 = new Node(5);
        Node<Integer> n6 = new Node(7);
        n0.setLeft(n1);
        n0.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        n2.setRight(n6);

        BinarySearchTree search = new BinarySearchTree();

        Node<Integer> node = search.searchValueRecursive(n0, 7);
        System.out.println(node);
    }

}
