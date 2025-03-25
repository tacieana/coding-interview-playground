package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

- Optei por criar a lista adicionando da direita para esquerda e depois revertendo os niveis pares
Runtime 100.00% / Memory 99.83%
 */
public class ZigZag {

    private final List<List<Integer>> zigzagList = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        addLevel(root, 0);

        for (int i = 0; i < zigzagList.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(zigzagList.get(i));
            }
        }
        return zigzagList;
    }

    private void addLevel(TreeNode node, int level) {
        if (node == null) return;

        if (zigzagList.size() == level) {
            zigzagList.add(new ArrayList<>());
        }

        zigzagList.get(level).add(node.val);

        addLevel(node.right, level + 1);
        addLevel(node.left, level + 1);

    }
}
