package leetcode.arrays.easy;

import java.util.HashSet;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed.
Return the number of elements in nums which are not equal to val.
Runtime - 100.00% / Memory - 81.49%
*/
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        HashSet<Integer> moved = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != val && !moved.contains(j)) {
                        nums[i] = nums[j];
                        moved.add(j);
                        j = i;
                    }
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
