package crackingcodeinterview.binarytree.classes;

public class NodeString {

    private String value;
    private NodeString left;
    private NodeString right;

    public NodeString() {
        value = null;
        left = null;
        right = null;
    }

    public NodeString(String value, NodeString left, NodeString right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public NodeString getLeft() {
        return left;
    }

    public void setLeft(NodeString left) {
        this.left = left;
    }

    public NodeString getRight() {
        return right;
    }

    public void setRight(NodeString right) {
        this.right = right;
    }

    public void printInOrderTransversal(NodeString node) {
        if (node != null) {
            printInOrderTransversal(node.getLeft());
            System.out.println(node.getValue());
            printInOrderTransversal(node.getRight());
        }
    }

    public void printPreOrderTransversal(NodeString node) {
        if (node != null) {
            System.out.println(node.getValue());
            printPreOrderTransversal(node.getLeft());
            printPreOrderTransversal(node.getRight());
        }
    }

    public void printPostOrderTransversal(NodeString node) {
        if (node != null) {
            printPostOrderTransversal(node.getLeft());
            printPostOrderTransversal(node.getRight());
            System.out.println(node.getValue());
        }
    }
}
