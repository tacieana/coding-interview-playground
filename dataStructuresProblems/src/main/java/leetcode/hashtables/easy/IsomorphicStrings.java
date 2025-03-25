package leetcode.hashtables.easy;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order
of characters. No two characters may map to the same character, but a character may map to itself.
Runtime 27.82% / Memory 84.37%
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> hashS = new HashMap<>();
        HashMap<Character, Character> hashT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);

            if ((hashS.containsKey(charS) && !hashS.get(charS).equals(charT))
                    || (hashT.containsKey(charT) && !hashT.get(charT).equals(charS))) {
                return false;
            }

            hashS.put(charS, charT);
            hashT.put(charT, charS);
        }

        return true;
    }
}
