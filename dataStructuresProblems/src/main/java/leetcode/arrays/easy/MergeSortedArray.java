package leetcode.arrays.easy;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Runtime 100.00%
Memory 44.31%
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{4, 3, 2, 1, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{9, 8, 7, 6, 5};

        mergeSortedArray.merge(nums1, 4, nums2, nums2.length);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        mergeSort(nums1);
    }

    private void mergeSort(int[] array) {
        if (array == null || array.length < 2) return;

        int size = array.length;
        int middle = size / 2;
        int[] left = new int[middle];
        int[] right = new int[size - middle];

        System.arraycopy(array, 0, left, 0, middle);

        if (size - middle >= 0) System.arraycopy(array, middle, right, middle - middle, size - middle);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }

    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftSize = left.length, rightSize = right.length;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
