class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=nums.length - 1; i>=0; i--){
            int val = nums[i];
            while(val > 0){
                list.add(val % 10);
                val /= 10;
            }
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}