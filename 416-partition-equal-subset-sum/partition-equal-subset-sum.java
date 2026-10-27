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
        boolean[] dp = new boolean[sum+1];

        dp[0] = true;
        if(nums[0] <= sum) dp[nums[0]] = true;
        for(int i=1; i<n; i++){
            for(int target=sum; target>= nums[i]; target--){  
        boolean nottake = dp[target];

        boolean take = dp[target - nums[i]];
         dp[target] = take || nottake;
            }
        }
        return dp[sum];
    }
}