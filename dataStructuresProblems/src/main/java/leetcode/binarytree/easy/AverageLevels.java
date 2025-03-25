package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Runtime Beats 28.95%
Memory Beats 75.75%
 */
public class AverageLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            double total = queue.size();
            double sum = 0D;

            for (int i = 0; i < total; i++) {

                TreeNode currentNode = queue.poll();
                sum = sum + currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            averages.add(sum / total);
        }

        return averages;
    }

}
