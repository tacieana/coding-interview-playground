package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).
Runtime 100.00% / Memory 99.37%
 */
public class LevelOrderTraversal {

    private final List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        addLine(root, 0);
        return list;
    }

    private void addLine(TreeNode node, int level) {
        if (node == null) return;

        if (list.size() == level) {
            list.add(new ArrayList());
        }

        list.get(level).add(node.val);
        addLine(node.left, level + 1);
        addLine(node.right, level + 1);
    }
}
