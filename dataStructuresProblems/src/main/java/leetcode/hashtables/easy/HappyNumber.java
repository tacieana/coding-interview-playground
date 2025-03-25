package leetcode.hashtables.easy;

import java.util.HashSet;

/*
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
Runtime 72.15% / Memory 76.35%
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> hash = new HashSet<>();

        while (n != 1) {
            hash.add(n);
            int square = 0;

            while (n > 0) {
                int remainder = n % 10;
                square += remainder * remainder;
                n /= 10;
            }

            if (hash.contains(square)) {
                return false;
            }

            n = square;
        }

        return true;
    }
}
