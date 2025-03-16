package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Runtime 100.00% / Memory 46.56%
public class InOrderTraversal {
    List<Integer> listInOrder = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        inOrderTraversal(root);
        return listInOrder;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            listInOrder.add(root.val);
            inorderTraversal(root.right);
        }
    }
}
