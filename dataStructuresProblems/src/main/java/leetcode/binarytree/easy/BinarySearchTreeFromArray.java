package leetcode.binarytree.easy;

import leetcode.binarytree.classes.TreeNode;

import java.util.Arrays;

/* Given an integer array where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.
Runtime 100.00% / Memory 5.23% */
public class BinarySearchTreeFromArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return new TreeNode();
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        if (nums.length == 2) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        }

        int rootIndex = nums.length/2;
        if ((nums.length % 2) == 0) {
            rootIndex = ((nums.length/2) -1);
        }

        int[] leftArray = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] rightArray = Arrays.copyOfRange(nums, rootIndex+1, nums.length);

        return new TreeNode(
                nums[rootIndex],
                sortedArrayToBST(leftArray),
                sortedArrayToBST(rightArray));

    }
}
