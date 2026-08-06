class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int minPro = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++){
            int temp = maxPro;
            maxPro = Math.max(nums[i],
                     Math.max(nums[i] * maxPro, nums[i] * minPro));
            minPro = Math.min(nums[i], 
                     Math.min(nums[i] * temp, nums[i] * minPro));
            ans = Math.max(maxPro, ans);
        }
        return ans; 
    }
}