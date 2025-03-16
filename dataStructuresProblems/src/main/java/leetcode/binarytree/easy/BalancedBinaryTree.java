package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
node never differs by more than one.
 */
public class BalancedBinaryTree {

    // Runtime beats 27.19%
    // Memory beats 73.37%
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int leftDepth = calcMaxDepth(root.left);
        int rightDepth = calcMaxDepth(root.right);

        if (Math.abs(leftDepth-rightDepth) >= 2) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calcMaxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftDepth = calcMaxDepth(node.left);
        int rightDepth = calcMaxDepth(node.right);
        return (rightDepth > leftDepth ? rightDepth : leftDepth) + 1;
    }
}
