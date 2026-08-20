class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] != val){
                left++;
            }else{
                while(left <= right && nums[right] == val){
                    right--;
                }
                if(left <= right){
                    nums[left] = nums[right];
                    left++;
                    right--;
                }
            }
        }
        return left;
    }
}