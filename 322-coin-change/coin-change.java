class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans =  helper(n - 1, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int helper(int i, int[] coins, int amount, int[][] dp){
        if(i == 0){
            if(amount % coins[0] == 0) 
            return amount/coins[0];
            return Integer.MAX_VALUE;
    }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int nottake = 0 + helper(i - 1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
             int ans = helper(i, coins, amount - coins[i], dp);
            if(ans != Integer.MAX_VALUE){
                take = 1 + ans;
            }
        }
        return dp[i][amount] = Math.min(take, nottake);
    }
}