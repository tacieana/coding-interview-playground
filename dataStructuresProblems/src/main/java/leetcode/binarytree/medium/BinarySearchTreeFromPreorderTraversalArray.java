package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;
import java.util.Arrays;

/*
Given an array of integers which represents the preorder traversal of a BST construct the tree and return its root.
It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
Runtime 100.00% / Memory 21.72%
 */
public class BinarySearchTreeFromPreorderTraversalArray {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        if(preorder.length == 1) {
            return new TreeNode(val);
        }

        int[] left = null, right = null;
        int rightFirstIndex = 1;
        if(preorder[rightFirstIndex] > val) {
            right = Arrays.copyOfRange(preorder, 1, preorder.length);
        } else {
            while(rightFirstIndex < preorder.length && preorder[rightFirstIndex] <= val) {
                rightFirstIndex++;
            }
            if(rightFirstIndex == preorder.length) {
                left = Arrays.copyOfRange(preorder, 1, preorder.length);
            } else {
                left = Arrays.copyOfRange(preorder, 1, rightFirstIndex);
                right = Arrays.copyOfRange(preorder, rightFirstIndex, preorder.length);
            }
        }

        return new TreeNode(val, bstFromPreorder(left), bstFromPreorder(right));
    }
}
