class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int i=0; i<n; i++){
            totSum += nums[i];
        }
        if(totSum % 2 != 0){
            return false;
        }
       int sum = totSum / 2;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0; i<n; i++){
        dp[i][0] = true;
        }
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i=1; i<n; i++){
            for(int target=1; target <= sum; target++){  
        boolean nottake = dp[i-1][target];
        boolean take = false;
        if(nums[i] <= target){
         take = dp[i-1][target - nums[i]];
        }
          dp[i][target] = take || nottake;
            }
        }
        return dp[n-1][sum];
    }
}