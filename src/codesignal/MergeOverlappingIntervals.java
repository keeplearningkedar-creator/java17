package codesignal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        int[] a1 = {2, 6};
        int[] a3 = {4, 8};
        int[] a2 = {10, 16};

        List<int[]> intervals = new ArrayList<>(List.of(a1, a2, a3));
        List<int[]> result = mergeIntervals(intervals);
        System.out.println(result);
    }

    private static List<int[]> mergeIntervals(List<int[]> intervals) {
        if(intervals == null || intervals.isEmpty() || intervals.size() < 1) return List.of();

        intervals.sort(Comparator.comparingInt( (int[] a) -> a[0]));

        ArrayList<int[]> merged = new ArrayList<>();
        int[] current = intervals.getFirst().clone();

        for(int[] interval : intervals) {
            if(interval[0] <= current[1]) {
                current[1] = Math.max(interval[1],current[1]);
            } else {
                merged.add(current);
                current = interval.clone();
            }
        }
        merged.add(current);
        return merged;
    }
}
