class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    public int helper(int n, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int f1 = helper(n - 1, dp);
        int f2 = helper(n -2, dp);
         dp[n] = f1 + f2;
         return dp[n];
    }
}