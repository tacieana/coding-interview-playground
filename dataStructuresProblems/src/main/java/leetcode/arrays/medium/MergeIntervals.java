package leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] anterior = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= anterior[1]) {
                anterior[1] = Math.max(anterior[1], intervals[i][1]);
            } else {
                merged.add(anterior);
                anterior = intervals[i];
            }

        }

        merged.add(anterior);
        return merged.toArray(new int[merged.size()][2]);
    }

}
