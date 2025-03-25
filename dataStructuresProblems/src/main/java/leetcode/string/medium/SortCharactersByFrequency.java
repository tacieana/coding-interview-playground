package leetcode.string.medium;

import java.util.*;

/*
Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
Runtime: 35.84% / Memory: 84.36%
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        HashMap<Character, Integer> frequencyCharHash = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char actualChar = s.charAt(i);
            int frequency = frequencyCharHash.getOrDefault(actualChar, 0);
            frequencyCharHash.put(actualChar, frequency+1);
        }

        PriorityQueue<CharFrequency> heap = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);

        frequencyCharHash.forEach((key, value) ->
            heap.offer(new CharFrequency(key, value)));

        return getString(heap);
    }

    private String getString(PriorityQueue<CharFrequency> heap) {

        StringBuilder stringBuilder = new StringBuilder();

        while (!heap.isEmpty()) {
            CharFrequency currentChar = heap.poll();

            for (int i = 1; i <= currentChar.frequency; i++) {
                stringBuilder.append(currentChar.value);
            }
        }

        return stringBuilder.toString();
    }

    private class CharFrequency {
        private char value;
        private int frequency;

        CharFrequency(char value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

    }
}
