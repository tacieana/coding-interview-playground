package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
path such that adding up all the values along the path equals targetSum.
Runtime 100.00% / Memory 49.75%
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return sum(root, 0, targetSum);
    }

    private boolean sum(TreeNode node, int sum, int targetSum) {
        if(node == null) return false;

        if(node.left == null && node.right == null) {
            if((sum+node.val) == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        if (node.left == null) {
            return sum(node.right, sum+node.val, targetSum);
        }

        if (node.right == null) {
            return sum(node.left, sum+node.val, targetSum);
        }

        return sum(node.left, sum+node.val, targetSum)
                || sum(node.right, sum+node.val, targetSum);
    }
}
