package leetcode.string.easy;

// Runtime - 45.29% / Memory 70.02%
public class ReverseWordsIII {
    public String reverseWords(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(reverse(word));
        }
        return stringBuilder.toString();
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
