package crackingCodeInterview.binaryTree.classes;

public class NodeInteger {

    private Integer value;
    private NodeInteger left;
    private NodeInteger right;

    public NodeInteger() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public NodeInteger(Integer value) {
        this.value = value;
    }

    public NodeInteger(Integer value, NodeInteger left, NodeInteger right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NodeInteger getLeft() {
        return left;
    }

    public void setLeft(NodeInteger left) {
        this.left = left;
    }

    public NodeInteger getRight() {
        return right;
    }

    public void setRight(NodeInteger right) {
        this.right = right;
    }

    public void printInOrderTransversal(NodeInteger node) {
        if (node != null) {
            printInOrderTransversal(node.left);
            System.out.println(node.value);
            printInOrderTransversal(node.right);
        }
    }

    public void printPreOrder(NodeInteger node) {
        if (node != null) {
            System.out.println(node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
}
