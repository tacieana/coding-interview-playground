package leetcode.arrays.easy;

import java.util.*;

/*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
Runtime: 11.85% / Memory: 21.57%
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 3) {
            return Collections.max(set);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : set) {
            heap.offer(num);
        }

        heap.poll();
        heap.poll();

        return heap.peek();
    }
}
