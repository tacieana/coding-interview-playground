package leetcode.hashtables.easy;

import java.util.HashMap;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the
letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
Runtime 37.50% / Memory 41.89%
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> letters = new HashMap();

        for (int i = 0; i < magazine.length(); i++) {
            if (letters.containsKey(magazine.charAt(i))) {
                letters.put(magazine.charAt(i), letters.get(magazine.charAt(i)) + 1);
            } else {
                letters.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!letters.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                Integer count = letters.get(ransomNote.charAt(i));
                if (count == 1) {
                    letters.remove(ransomNote.charAt(i));
                } else {
                    letters.put(ransomNote.charAt(i), count - 1);
                }
            }
        }

        return true;
    }
}
