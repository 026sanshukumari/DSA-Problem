class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        int count = 1;
        for(int[] interval : intervals){
            if(interval[0] >= lastEnd){
                lastEnd = interval[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}