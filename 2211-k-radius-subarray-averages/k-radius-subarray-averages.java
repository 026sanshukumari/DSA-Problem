class Solution {
    public int[] getAverages(int[] nums, int k) {
        int left = 0;
        long sum = 0;
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            if(right - left + 1 == 2 * k + 1){
                avg[right - k] = (int) (sum / (2 * k + 1));
                sum -= nums[left];
                left++;
            }
        }
        return avg;
    }
}