package leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need:
Change the array nums such that the first k elements of nums contain the unique elements
in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums. Return k.
 */
public class RemoveDuplicatesSortedArray {

    // Runtime 5ms - 7.29% / Memory 45.54MB - 7.04%
    public int removeDuplicatesBruteForce(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int num : nums) {
            list.add(num);
        }

        list = new ArrayList(new LinkedHashSet(list));

        for (int i=0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    // Runtime 100.00% / Memory 42.36%
    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
