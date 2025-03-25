package leetcode.hashtables.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays
you may return the result in any order.
 */
public class IntersectionOfTwoArrays2 {

    // Runtime 10.38% / Memory 8.51%
    public static int[] bruteForce(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashmap1 = new HashMap<>();
        HashMap<Integer, Integer> hashmap2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if (hashmap1.containsKey(nums1[i])) {
                hashmap1.put(nums1[i], hashmap1.get(nums1[i]) + 1);
            } else {
                hashmap1.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashmap2.containsKey(nums2[i])) {
                hashmap2.put(nums2[i], hashmap2.get(nums2[i]) + 1);
            } else {
                hashmap2.put(nums2[i], 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        hashmap1.forEach((key, value) -> {
            if (hashmap2.containsKey(key)) {
                int count = value <= hashmap2.get(key) ? value : hashmap2.get(key);
                for (int i = 0; i < count; i++) {
                    answer.add(key);
                }
            }
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // Runtime 91.85% / Memory 57.89%
    public static int[] secondSolution(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return secondSolution(nums2, nums1);
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int index = 0;

        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                result[index++] = num;
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] finalResult = new int[index];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    }
}
