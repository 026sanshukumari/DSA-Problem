class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int totNum = 0;
        for(int num : nums){
            if(count == 0){
                totNum = num;
            }
            if(totNum == num){
                count++;
            }else{
                count--;
            }
        }
        return totNum;
    }
}