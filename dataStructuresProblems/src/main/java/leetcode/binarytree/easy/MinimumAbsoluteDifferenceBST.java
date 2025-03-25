package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a Binary Search Tree (BST),
return the minimum absolute difference between the values of any two different nodes in the tree.
Runtime 5.04% / Memory 77.85%
 */
public class MinimumAbsoluteDifferenceBST {

    List<Integer> inOrderArray = new ArrayList();

    public int getMinimumDifference(TreeNode root) {

        setInOrderArray(root);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < inOrderArray.size(); i++) {
            for (int j = i + 1; j < inOrderArray.size(); j++) {
                int diff = Math.abs(inOrderArray.get(j) - inOrderArray.get(i));
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
        }

        return minDiff;
    }

    private void setInOrderArray(TreeNode node) {
        if (node == null) return;

        setInOrderArray(node.left);
        inOrderArray.add(node.val);
        setInOrderArray(node.right);
    }
}
