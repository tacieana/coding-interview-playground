package leetcode.arrays.hard;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
start time: 11:30 - end time: 11:47
Runtime: 100.00% - Memory 12.93%
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = merge(nums1, nums2);

        int i = merged.length / 2;
        if (merged.length % 2 == 0) {
            return (merged[i - 1] + merged[i]) / 2D;
        }

        return merged[i];
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, i1 = 0, i2 = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                mergedArray[i] = nums1[i1];
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                mergedArray[i] = nums1[i1];
                i1++;
            } else {
                mergedArray[i] = nums2[i2];
                i2++;
            }
            i++;
        }

        while (i1 < nums1.length) {
            mergedArray[i] = nums1[i1];
            i1++;
            i++;
        }

        while (i2 < nums2.length) {
            mergedArray[i] = nums2[i2];
            i2++;
            i++;
        }

        return mergedArray;
    }
}
