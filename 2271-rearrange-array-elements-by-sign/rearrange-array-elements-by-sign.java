class Solution {
    public int[] rearrangeArray(int[] nums) {
        int evenPos = 0;
        int oddPos = 1;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                ans[evenPos] = nums[i];
                evenPos += 2;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                ans[oddPos] = nums[i];
                oddPos += 2;
            }
        }
        return ans;
    }
}