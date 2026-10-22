class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    public int helper(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ways1 = helper(n-1, dp);
        int ways2 = helper(n -2, dp);
        dp[n] = ways1 + ways2;
        return dp[n];
    }
}