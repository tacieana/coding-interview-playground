package leetcode.hashtables.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique, you may return the result in any order. */
public class IntersectionOfTwoArrays {

    // Runtime Beats 96.69% / Memory beats 61.16%
    public int[] hashSetSolution(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSetNum1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int j : nums1) {
            hashSetNum1.add(j);
        }

        for (int j : nums2) {
            if (hashSetNum1.contains(j)) {
                intersection.add(j);
            }
        }

        int[] answer = new int[intersection.size()];
        int i = 0;

        for (var currentNumber : intersection) {
            answer[i++] = currentNumber;
        }
        return answer;
    }

    // Runtime Beats 14.41% / Memory beats 5.82%
    public int[] bruteForce(int[] nums1, int[] nums2) {

        int[] bigger;
        int[] lower;
        List<Integer> intersection = new ArrayList<>();

        HashMap<Integer, Integer> hashtableBigger = new HashMap<>();
        HashMap<Integer, Integer> hashtableLower = new HashMap<>();

        if (nums1.length > nums2.length) {
            bigger = nums1;
            lower = nums2;
        } else {
            bigger = nums2;
            lower = nums1;
        }

        for (int i = 0; i < bigger.length; i++) {
            hashtableBigger.put(bigger[i], i);

            if (i < lower.length) {
                hashtableLower.put(lower[i], i);
            }
        }

        for (int i = 0; i < bigger.length; i++) {
            if (hashtableLower.containsKey(bigger[i]) && !intersection.contains(bigger[i])) {
                intersection.add(bigger[i]);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
