package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

/*
Given the root of a binary tree, invert the tree, and return its root.
Runtime 100.00% / Memory 25.80%
*/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
