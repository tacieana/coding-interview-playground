package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

public class MaximumDepth {

    // Runtime 100.00%
    // Memory 87.52%
    public int maxDepth(TreeNode root) {
        return calcDepth(root);
    }

    private int calcDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = calcDepth(root.left);
        int rightDepth = calcDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
