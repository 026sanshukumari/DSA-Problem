class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int l = 0;
        int r = 0;
        long totalCnt = 0;
        int cntMax = 0;
        while(r < n){
            if(nums[r] == max){
                cntMax++;
            }
            while(cntMax >= k){
                totalCnt += (n - r);
                if(nums[l] == max){
                    cntMax--;
                }
                l++;
            }
            r++;
        }
        return totalCnt;

    }
}