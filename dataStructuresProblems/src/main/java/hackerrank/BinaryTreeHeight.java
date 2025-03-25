package hackerrank;

import lombok.Getter;

public class BinaryTreeHeight {

    class Node {
        @Getter
        private int value;
        private Node left;
        private Node right;
    }

    private static int getHeight(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
