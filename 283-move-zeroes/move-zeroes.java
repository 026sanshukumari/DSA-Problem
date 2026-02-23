class Solution {
    public void moveZeroes(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[res++] = nums[i];
            }
        }
            while(res < nums.length){
                nums[res++] = 0;
        }
    }
}