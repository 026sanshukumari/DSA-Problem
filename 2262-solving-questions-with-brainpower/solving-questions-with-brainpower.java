class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }
    public long solve(int i, int[][] questions, long[] dp){
        if(i >= questions.length) return 0;
        if(dp[i] != -1) return dp[i];
        int next = i + questions[i][1] + 1;
        long take = questions[i][0] + solve(next, questions, dp);
        long skip = solve(i+1, questions, dp);
        dp[i] =  Math.max(take, skip);
        return dp[i];
    }
}