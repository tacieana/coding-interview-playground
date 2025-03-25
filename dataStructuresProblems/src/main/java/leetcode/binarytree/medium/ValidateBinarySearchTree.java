package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
Runtime 24.42% / Memory 95.58%  */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBST(root.left)
                && isValidBST(root.right)
                && allLower(root.left, root.val)
                && allGreater(root.right, root.val);

    }

    private boolean allLower(TreeNode node, int val) {
        if (node == null) return true;

        return node.val < val && allLower(node.left, val) && allLower(node.right, val);
    }

    private boolean allGreater(TreeNode node, int val) {
        if (node == null) return true;

        return node.val > val && allGreater(node.left, val) && allGreater(node.right, val);
    }

}
