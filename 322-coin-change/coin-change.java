class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int t=0; t<=amount; t++){
            if(t % coins[0] == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = Integer.MAX_VALUE;
        }
        for(int i=1; i<n; i++){
            for(int t=0; t<=amount; t++){
                int nottake = 0 + dp[i-1][t];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= t){
                    int prev = dp[i][t-coins[i]];
                    if(prev != Integer.MAX_VALUE){
                        take = 1 + prev;
                    }
                }
                dp[i][t] = Math.min(take, nottake);
            }
        }
            int ans = dp[n-1][amount];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}