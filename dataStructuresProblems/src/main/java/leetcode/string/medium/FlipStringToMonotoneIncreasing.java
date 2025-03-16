package leetcode.string.medium;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        int min = 0, max = s.length()-1;
        char[] chars = s.toCharArray();

        while (min <= max){
            if (chars[min] == '0') {
                min++;
            } else if ((chars[max] == '1')) {
                max--;
            } else {
                flips++;
                min++;
                max--;
            }
        }
        return flips;
    }
}
