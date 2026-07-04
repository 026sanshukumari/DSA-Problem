class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(0, cost, dp), helper(1, cost, dp));
    }

    private int helper(int i, int[] cost, int[] dp){
        if(i >= cost.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int one = helper(i+1, cost, dp);
        int sec = helper(i+2, cost, dp);
        dp[i] = cost[i] + Math.min(one, sec);
        return dp[i];

    }
}