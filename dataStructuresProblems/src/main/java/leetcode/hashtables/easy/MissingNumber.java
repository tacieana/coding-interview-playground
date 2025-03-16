package leetcode.hashtables.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Constraints:
- n == nums.length
- 1 <= n <= 104
- 0 <= nums[i] <= n
- All the numbers of nums are unique.

Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class MissingNumber {

    // Runtime Beats 24.75% / Memory Beats 7.74%
    public int missingNumber(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], true);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!hashMap.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }

    // Runtime Beats 100.00% / Memory Beats 43.88%
    public int missingNumberV2(int[] nums) {
        int[] allNumbersVector = new int[nums.length+1];
        Arrays.fill(allNumbersVector, -1);

        for (int i = 0; i < nums.length; i++) {
            allNumbersVector[nums[i]] = i;
        }

        for (int i = 0; i <= nums.length; i++) {
            if(allNumbersVector[i] == -1) {
                return i;
            }
        }

        return 0;
    }
}
