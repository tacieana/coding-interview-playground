package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
Runtime 100.00% / Memory 36.13%
 */
public class SmallestElementBinarySearchTree {

    List<Integer> nodes = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        visitNode(root, k);
        return nodes.get(k-1);
    }

    private void visitNode(TreeNode node, int k) {
        if(node == null || nodes.size() >= k) return;

        visitNode(node.left, k);
        nodes.add(node.val);
        visitNode(node.right, k);
    }
}
