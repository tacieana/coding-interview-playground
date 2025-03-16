package theoryexamples;

import model.Node;
import java.util.Stack;

public class BinaryTreeDepthFirstSearch {

    public static void main(String args[]) {
        Node<Integer> n0 = new Node(0);
        Node<Integer> n1 = new Node(1);
        Node<Integer> n2 = new Node(2);
        Node<Integer> n3 = new Node(3);
        Node<Integer> n4 = new Node(4);
        Node<Integer> n5 = new Node(5);
        Node<Integer> n6 = new Node(6);

        n0.setLeft(n1);
        n0.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n4.setLeft(n5);
        n4.setRight(n6);

        System.out.println("pre order: 0,1,3,4,5,6,2");
        System.out.println("stack");
        printPreOrderStack(n0);
        System.out.println("recursion");
        printPreOrderRecursive(n0);

        System.out.println("in order: 3,1,5,4,6,0,2");
        System.out.println("stack");
        printInOrderStack(n0);
        System.out.println("recursion");
        printInOrderRecursive(n0);

        System.out.println("post order: 3,5,6,4,1,2,0");
        System.out.println("stack");
        printPostOrderStack(n0);
        System.out.println("recursion");
        printPostOrderRecursive(n0);

    }

    private static void printPreOrderStack(Node<Integer> root) {
        Stack<Node<Integer>> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node<Integer> current = stack.pop();
            if (current != null) {
                System.out.println(current.getValue());
                stack.push(current.getRight());
                stack.push(current.getLeft());
            }
        }

    }

    private static void printInOrderStack(Node<Integer> root) {
        if (root == null) return;
        Stack<Node<Integer>> stack = new Stack();
        Node<Integer> current = root;

        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            System.out.println(current.getValue());
            current = current.getRight();
        }

    }

    private static void printPostOrderStack(Node<Integer> root) {
        if (root == null) return;

        Stack<Node<Integer>> stack = new Stack();
        Stack<Node<Integer>> output = new Stack();
        Node<Integer> current;
        stack.push(root);

        while(!stack.isEmpty()) {
            current = stack.pop();
            output.push(current);

            if(current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            if(current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        while(!output.isEmpty()) {
            System.out.println(output.pop().getValue());
        }

    }

    private static void printPreOrderRecursive(Node<Integer> node) {
        if (node != null) {
            System.out.println(node.getValue());
            printPreOrderRecursive(node.getLeft());
            printPreOrderRecursive(node.getRight());
        }
    }

    private static void printInOrderRecursive(Node<Integer> node) {
        if (node != null) {
            printInOrderRecursive(node.getLeft());
            System.out.println(node.getValue());
            printInOrderRecursive(node.getRight());
        }
    }

    private static void printPostOrderRecursive(Node<Integer> node) {
        if (node != null) {
            printPostOrderRecursive(node.getLeft());
            printPostOrderRecursive(node.getRight());
            System.out.println(node.getValue());
        }
    }


}
