package leetcode.hashtables.easy;

import java.util.HashSet;

/* Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
Runtime 12ms - 49.20% / Memory 58.00MB - 46.08% */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for (int num : nums) {
            if (hash.contains(num)) {
                return true;
            }
            hash.add(num);
        }

        return false;
    }
}
