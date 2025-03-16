package leetcode.kfactor;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two positive integers n and k.
 * A factor of an integer n is defined as an integer i on n % i == 0.
 * Consider a list of all factors of n sorted in ascending order,
 * return the kth factor in this list
 * or return -1 if n has less than k factors.
 * Runtime: 7.5% / Memory: 26%
 */
public class FactorFinder {

    public Integer kthFactor(Integer n, Integer k) {
        List<Integer> factors = listAllFactors(n);

        if(factors.size() < k){
            return -1;
        }

        return factors.get(k-1);
    }

    private List<Integer> listAllFactors(Integer n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ((n%i) == 0) {
                factors.add(i);
            }
        }

        return factors;
    }
}
