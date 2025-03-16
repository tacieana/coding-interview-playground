package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

/* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical,
and the nodes have the same value.
Runtime 100.00% / Memory 41.29%
*/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        } else {
            if((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }
}
