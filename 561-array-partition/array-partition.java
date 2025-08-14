class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            int x = nums[i];
            int y = nums[i+1];
            int min = x;
            sum += min;
        }
        return sum;

    }
}