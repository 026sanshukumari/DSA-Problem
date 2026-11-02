class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        for(int i=n-1; i>=0; i--){
            for(int prev_idx=i-1; prev_idx>=-1; prev_idx--){
                int len = 0 + next[prev_idx+1];
                  if(prev_idx == -1 || nums[i] > nums[prev_idx]){
                      len = Math.max(len, 1 + next[i+1]);
        }
        curr[prev_idx+1] = len;
            }
            next = curr;
        }

     return next[0];
    }
}