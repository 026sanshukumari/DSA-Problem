class Solution {
    public int jump(int[] nums) {
        int farther = 0;
        int jump = 0;
        int currEnd = 0;
        for(int i=0; i<nums.length - 1; i++){
            farther = Math.max(farther, nums[i] + i);
        if(i == currEnd){
            jump++;
            currEnd = farther;
        }
        }
        return jump;
    }
}