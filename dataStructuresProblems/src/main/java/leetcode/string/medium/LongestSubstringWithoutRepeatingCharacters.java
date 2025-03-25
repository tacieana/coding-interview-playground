package leetcode.string.medium;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.
Runtime: 39.14% / Memory: 46.04%
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();
        int first = 0;
        int last = 0;
        int maxLength = 1;

        while(last < s.length()) {

            if (seen.contains(s.charAt(last))) {
                seen.remove(s.charAt(first));
                first++;
            } else {
                seen.add(s.charAt(last));
                last++;
                maxLength = Math.max(maxLength, last - first);
            }

        }
        return maxLength;

    }
}
