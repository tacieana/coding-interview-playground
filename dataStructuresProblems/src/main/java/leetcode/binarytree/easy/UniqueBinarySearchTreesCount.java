package leetcode.binarytree.easy;

import java.math.BigInteger;
import java.util.HashMap;

/* Given an integer n, return the number of structurally unique BST's (binary search trees)
which has exactly n nodes of unique values from 1 to n.
Runtime 17.87% / Memory 18.61% */
public class UniqueBinarySearchTreesCount {

    private final BigInteger ONE = BigInteger.valueOf(1);
    private final BigInteger TWO = BigInteger.valueOf(2);
    private HashMap<BigInteger,BigInteger> factorials = new HashMap();

    public int numTrees(int n) {
        BigInteger nBig = BigInteger.valueOf(n);
        BigInteger result = factorial(nBig.multiply(TWO)).divide(
                factorial(nBig.add(ONE)).multiply(factorial(nBig)));

        return result.intValue();
    }

    public BigInteger factorial(BigInteger n) {
        if(!factorials.containsKey(n)) {
            if (n.compareTo(ONE) <= 0) {
                factorials.put(n, ONE);
            } else {
                factorials.put(n, n.multiply(factorial(n.subtract(ONE))));
            }
        }
        return factorials.get(n);
    }
}
