class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if(nums[i] > max){
                max = Math.max(max, nums[i]);
            }
        }
        if(nums.length != max + 1) {
            return false;
        }
        if(freq.get(max) != 2){
            return false;
        }
        for(int i=1; i<max; i++){
            if(freq.get(i) == null || freq.get(i) != 1){
                return false;
            }
        }
        return true;
    }
}