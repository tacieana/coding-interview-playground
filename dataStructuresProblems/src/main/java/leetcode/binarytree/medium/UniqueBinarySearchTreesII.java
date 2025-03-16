package leetcode.binarytree.medium;

import leetcode.binarytree.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return all the structurally unique BST's (binary search trees),
which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
Runtime 97.92% / Memory 58.55%
 */
public class UniqueBinarySearchTreesII {

    public static void main(String args[]) {
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        List<TreeNode> trees = uniqueBinarySearchTreesII.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {

        if (n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i-1);
            List<TreeNode> rightTree = generateTrees(i+1, end);

            for(TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree){
                    trees.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return trees;
    }
}
