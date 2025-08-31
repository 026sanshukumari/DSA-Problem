class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] result = new int[n][2];
        int idx = 0;

        result[0] = intervals[0];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= result[idx][1]) {
                result[idx][1] = Math.max(result[idx][1], intervals[i][1]);
            } else {
                result[++idx] = intervals[i];
            }
        }

        return Arrays.copyOf(result, idx + 1);
    }
}
