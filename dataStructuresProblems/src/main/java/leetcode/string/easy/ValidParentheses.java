package leetcode.string.easy;

import java.util.Stack;

// Runtime: 42.04% / Memory: 65.69%
public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpenChar(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && isOpenCloseCorrect(stack.peek(), c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenChar(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isOpenCloseCorrect(char open, char close) {
        switch (open) {
            case '(':
                return close == ')';
            case '[':
                return close == ']';
            case '{':
                return close == '}';
            default:
                return false;
        }
    }


    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}
