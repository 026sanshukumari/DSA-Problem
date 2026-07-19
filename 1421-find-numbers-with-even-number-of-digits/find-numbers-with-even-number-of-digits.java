class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int digitcnt = 0;
            while(curr > 0){
            digitcnt++;
            curr = curr / 10;
            }
            if(digitcnt % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
}