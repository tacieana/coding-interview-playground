package leetcode.hashtables.easy;

import java.util.Hashtable;

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.
Runtime 64.99% / Memory 31.14%
 */
public class SumTwoTarget {
    public int[] twoSum(int[] nums, int target) {

        Hashtable hashtable = new Hashtable<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hashtable.containsKey(complement)) {
                return new int[]{(int) hashtable.get(complement), i};
            }
            hashtable.put(nums[i], i);
        }

        return new int[]{};
    }
}
