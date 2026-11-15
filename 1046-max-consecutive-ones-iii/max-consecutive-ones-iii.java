class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int sum = 0;
        int zerocnt = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                sum -= 1;
                zerocnt++;
            }else{
                sum += 1;
            }
            while(zerocnt > k){
               if(nums[left] == 0){
                sum += 1;
                zerocnt--;
               }else{
                sum -= 1;
               }
               left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}