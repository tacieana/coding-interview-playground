package leetcode.arrays.medium;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
Runtime: 57.44% / Memory: 54.52%
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        int i = 1;
        while (i < k) {
            heap.poll();
            i++;
        }

        return heap.poll();
    }
}
