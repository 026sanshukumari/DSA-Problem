class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int l=0;
        int r = 0;
        long totalCount = 0;
        int CountMax = 0;
        while(r < n){
            if(nums[r] == max){
                CountMax++;
            }
            while(CountMax >= k){
                totalCount += (n - r);
                if(nums[l] == max){
                    CountMax--;
                }
                l++;
            }
            r++;
        }
        return totalCount;
    }
}