class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a,b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            ans.append(arr[i]);
        }
        String res = ans.toString();
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }
}