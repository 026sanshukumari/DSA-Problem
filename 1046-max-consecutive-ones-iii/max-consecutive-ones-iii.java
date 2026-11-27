class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxCnt = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                sum += 1;
            }
            while(sum > k){
                if(nums[left] == 0){
                    sum -= 1;
                }
                left++;
            }
            maxCnt = Math.max(maxCnt, right - left + 1);
        }
        return maxCnt;
    }
}