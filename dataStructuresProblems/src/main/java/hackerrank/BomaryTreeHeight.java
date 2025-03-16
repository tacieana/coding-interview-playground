package hackerrank;

public class BomaryTreeHeight {
    public static void main(String[] args) {
    }

    class Node {
        public int value;
        public Node left;
        public Node right;
    }
    private static int getHeight(Node node) {
        if(node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
