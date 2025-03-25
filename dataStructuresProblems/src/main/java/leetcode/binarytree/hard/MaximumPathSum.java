package leetcode.binarytree.hard;

import leetcode.binarytree.classes.TreeNode;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
has an edge connecting them. A node can only appear in the sequence at most once.
Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;

        int maxPathSumLeft = Math.max(0, sum(node.left));
        int maxPathSumRight = Math.max(0, sum(node.right));

        int currentSum = node.val + maxPathSumLeft + maxPathSumRight;
        maxSum = Math.max(maxSum, currentSum);

        return node.val + Math.max(maxPathSumLeft, maxPathSumRight);
    }
}
