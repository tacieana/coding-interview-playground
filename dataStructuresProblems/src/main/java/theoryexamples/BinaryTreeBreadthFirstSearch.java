package theoryexamples;

import model.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBreadthFirstSearch {

    private void printValuesBfsTraverse(Node<Integer> root) {

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<Integer> currentNode = queue.poll();
            System.out.println(currentNode.getValue());

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
    }

}
