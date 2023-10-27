package javaSolutions.src.old.Grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval: intervals) {

            if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.addAll(Arrays.asList(intervals));
                int[][] output = new int[result.size()][2];
                for (int i = 0; i < result.size(); i++) {
                    output[i] = result.get(i);
                }
                return output;
            } else if (newInterval[0] > interval[1]) {
                result.add(interval);
            } else {
                newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            }
        }
        result.add(newInterval);
        int[][] output = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5})));
    }
}
