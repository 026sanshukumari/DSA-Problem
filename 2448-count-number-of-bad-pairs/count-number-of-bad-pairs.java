class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int relation = nums[i] - i;
            map.put(relation,map.getOrDefault(relation,0) + 1);
        }
        long goodPair = 0;
        for(int freq : map.values()){
            goodPair += (long) freq * (freq - 1)/2;
        }
        long totalPair = (long) nums.length * (nums.length - 1)/2;
        return totalPair - goodPair;
    }
}