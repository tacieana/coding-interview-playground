package leetcode.arrays.easy;

import java.util.PriorityQueue;

/*
Runtime: 92.12% / Memory: 91.47%
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {

        PriorityQueue<Rank> heap = new PriorityQueue<Rank>((rank1, rank2) -> rank2.score - rank1.score);

        for (int i = 0; i < score.length; i++) {
            heap.add(new Rank(i, score[i]));
        }

        String[] result = new String[score.length];
        int i = 1;
        while (!heap.isEmpty()) {
            Rank actual = heap.poll();
            switch (i) {
                case 1:
                    result[actual.index] = "Gold Medal";
                    break;
                case 2:
                    result[actual.index] = "Silver Medal";
                    break;
                case 3:
                    result[actual.index] = "Bronze Medal";
                    break;
                default:
                    result[actual.index] = String.valueOf(i);
            }
            i++;
        }
        return result;
    }

    private class Rank {
        public int index;
        public int score;

        Rank(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
