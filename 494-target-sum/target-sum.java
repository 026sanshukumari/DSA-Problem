class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        int totSum = 0;
        for(int i=0; i<n; i++){
            totSum += nums[i];
        }
        if(Math.abs(target) > totSum){
            return 0;
        }
        if((totSum + target) % 2 != 0){
            return 0;
        }

        int sum = (totSum + target) / 2;
        int[][] dp = new int[n][sum+1];
        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
            if(nums[0] <= sum){
               dp[0][nums[0]] = 1;
            }
        }
        for(int i=1; i<n; i++){
            for(int s=0; s<=sum; s++){
                int nottake = dp[i-1][s];
                int take = 0;
                if(nums[i] <= s){
                    take = dp[i-1][s - nums[i]];
                }
                dp[i][s] = take + nottake;
            }
        }
        return dp[n-1][sum];
    }
}