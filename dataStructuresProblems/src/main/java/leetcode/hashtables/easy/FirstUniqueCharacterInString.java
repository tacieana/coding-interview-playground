package leetcode.hashtables.easy;

import java.util.HashSet;
import java.util.LinkedHashMap;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Runtime 59.17% / Memory: 81.82%
 */
public class FirstUniqueCharacterInString {
    public int firstUniqueChar(String s) {

        LinkedHashMap<Character, Integer> uniques = new LinkedHashMap();
        HashSet<Character> repeated = new HashSet();

        for (int i=0; i < s.length(); i++) {
            Character current = s.charAt(i);

            if (uniques.containsKey(current)) {
                uniques.remove(current);
                repeated.add(current);
            } else if(!repeated.contains(current)) {
                uniques.put(current, i);
            }
        }

        if (!uniques.isEmpty()) {
            return uniques.entrySet().iterator().next().getValue();
        }

        return -1;
    }
}
