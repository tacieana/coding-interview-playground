package leetcode.hashtables.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 * Note that each character should belong to exactly one substring in a partition.
 */
public class PartitionUniqueString {
    public int partitionString(String s) {
        if (s.length() == 1) {
            return 1;
        }

        List<String> uniqueStrings = new ArrayList<>();
        char[] characters = s.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char atualCaracter = characters[i];

            if (uniqueStrings.isEmpty()) {
                uniqueStrings.add(String.valueOf(atualCaracter));
            } else {
                int lastIndex = uniqueStrings.size() - 1;
                String lastString = uniqueStrings.get(lastIndex);

                if (lastString.contains(atualCaracter + "")) {
                    uniqueStrings.add(atualCaracter + "");
                } else {
                    uniqueStrings.set(lastIndex, lastString.concat(atualCaracter + ""));
                }
            }
        }
        return uniqueStrings.size();
    }

}
