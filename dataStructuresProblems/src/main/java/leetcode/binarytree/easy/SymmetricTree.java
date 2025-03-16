package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

// Given the root of a binary tree, check whether it is a mirror of itself
public class SymmetricTree {

    // Runtime Beats 100.00%
    // Memory beats 31.30%
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }

            return (isMirror(left.left, right.right) && isMirror(right.left, left.right));
        }

        if(left == null && right == null) {
            return true;
        }

        return false;
    }
}
