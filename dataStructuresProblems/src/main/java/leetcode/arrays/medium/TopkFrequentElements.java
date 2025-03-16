package leetcode.arrays.medium;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Runtime 20.92% / Memory 33.32%
 */
public class TopkFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencyMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int currentFrequency = frequencyMap.getOrDefault(nums[i], 0);
            frequencyMap.put(nums[i], currentFrequency+1);
        }

        List<Map.Entry<Integer,Integer>> orderedList = new ArrayList(frequencyMap.entrySet());
        orderedList.sort((value1, value2) -> value2.getValue().compareTo(value1.getValue()));
        int[] topK = new int[Math.min(k, orderedList.size())];
        int i = 0;
        while(i < topK.length) {
            topK[i] = orderedList.get(i).getKey();
            i++;
        }

        return topK;
    }
}
