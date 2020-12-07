import java.util.*;
public class Solution {
    //Runtime: 2 ms, faster than 78.55%
    //Memory Usage: 39 MB, less than 97.29%
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
                @Override
                public int compare(int [] a1, int [] a2){
                    return a1[1] - a2[1];
                }
            });
        int maxNOI  = 0; // NOI => Non-overlap Intervals
        int prevEnd = intervals[0][0];
        for(int i = 0; i < intervals.length; i++){
            if(prevEnd <= intervals[i][0]){
                maxNOI++;
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length - maxNOI;
    }
}
