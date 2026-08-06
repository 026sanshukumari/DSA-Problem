class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int EvenPos = 0;
        int OddPos = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                ans[EvenPos] = nums[i];
                EvenPos += 2;
            }else{
                ans[OddPos] = nums[i];
                OddPos += 2;
            }
        }
        return ans;
    }
}