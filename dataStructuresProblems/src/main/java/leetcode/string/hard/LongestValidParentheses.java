package leetcode.string.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Character> stackOpen = new Stack<>();
        Stack<Character> stackClose = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stackOpen.push(c);
            } else {
                if(!stackOpen.isEmpty()) {
                    stackClose.push(c);
                }
            }
        }

        return Math.min(stackOpen.size(), stackClose.size()) * 2;
    }
}
