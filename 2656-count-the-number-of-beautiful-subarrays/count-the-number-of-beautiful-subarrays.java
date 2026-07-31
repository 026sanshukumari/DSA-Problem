class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int xor = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int num : nums){
            xor ^= num;
            if(map.containsKey(xor)){
                ans += map.get(xor);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return ans;

    }
}