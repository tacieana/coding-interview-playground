package leetcode.arrays.easy;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Runtime: 31.11% / Memory 34.15%
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        char[] letters = s.toCharArray();
        int min = 0, max = letters.length - 1;

        while (min <= max) {
            if (letters[min] != letters[max]) {
                return false;
            }
            max--;
            min++;
        }

        return true;

    }
}
