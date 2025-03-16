package leetcode.hashtables.easy;

import java.util.HashMap;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j
in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Runtime 83.51% / Memory 57.20%
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap();

        for(int i=0; i < nums.length; i++) {
            if (hash.containsKey(nums[i]) && Math.abs(i-hash.get(nums[i])) <= k) {
                return true;
            } else {
                hash.put(nums[i], i);
            }
        }

        return false;
    }
}
