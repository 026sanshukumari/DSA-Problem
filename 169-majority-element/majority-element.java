class Solution {
    public int majorityElement(int[] nums) {
        int res = 0; 
        int majority = 0;
        for(int num : nums){
            if(majority == 0){
                res = num;
            }
            majority += num == res ? 1 : -1;
        }
        return res;
    }
}