package java.ds.arrays.mergedIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    private static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][0];

        List<int []> merged = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                merged.add(new int[] {currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        merged.add(new int[] {currentStart, currentEnd});

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] input = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };
        int[][] out = merge(input);
        for (int[] in : out) System.out.println(Arrays.toString(in));
    }
}
