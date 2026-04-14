class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        int max = 0;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];
            while((long)(r - l + 1) * nums[r] - sum > k){
                sum -= nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}