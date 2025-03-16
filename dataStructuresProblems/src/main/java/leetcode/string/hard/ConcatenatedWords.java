package leetcode.string.hard;

import java.util.*;

/*
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array
Runtime: / Memory:
 */
public class ConcatenatedWords {

    public static void main(String args[]) {
        List<String> teste = findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (isConcatenated(word, wordSet, memo)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean isConcatenated(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isConcatenated(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }
}
