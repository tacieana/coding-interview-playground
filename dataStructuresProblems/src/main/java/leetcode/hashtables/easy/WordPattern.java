package leetcode.hashtables.easy;

import java.util.HashMap;

/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

- Each letter in pattern maps to exactly one unique word in s.
- Each unique word in s maps to exactly one letter in pattern.
- No two letters map to the same word, and no two words map to the same letter.

Runtime 81.68% / Memory 48.33%
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        String[] sSplited = s.split(" ");

        if (sSplited.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> hashMapPattern = new HashMap<>();
        HashMap<String, Character> hashMapString = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character actualChar = pattern.charAt(i);

            if ((hashMapPattern.containsKey(actualChar)
                    && (!hashMapPattern.get(actualChar).equals(sSplited[i])))
                    || (hashMapString.containsKey(sSplited[i])
                    && !hashMapString.get(sSplited[i]).equals(actualChar))) {
                return false;
            }

            hashMapPattern.put(actualChar, sSplited[i]);
            hashMapString.put(sSplited[i], actualChar);

        }

        return true;
    }
}
