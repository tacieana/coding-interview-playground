package leetcode.topInterview.medium;

import java.util.ArrayList;
import java.util.List;

// Runtime: 43.96% / Memory: 48.80%
public class TheKthFactor {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList();

        int i=1;
        while (i <= n && factors.size() < k) {
            if (n % i == 0) {
                factors.add(i);
            }
            i++;
        }

        if (factors.size() >= k) {
            return factors.get(k-1);
        }
        return -1;
    }
}
