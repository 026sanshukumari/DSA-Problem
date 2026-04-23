class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int LastEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < LastEnd){
                count++;
            }else{
                LastEnd = intervals[i][1];
            }
        }
        return count;
    }
}