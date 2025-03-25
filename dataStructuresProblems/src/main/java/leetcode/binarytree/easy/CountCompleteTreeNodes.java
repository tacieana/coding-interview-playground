package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.
Runtime: 100.00% / Memory 90.05%
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
