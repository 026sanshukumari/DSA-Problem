class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i= 2 * n - 1; i>=0; i--){
            int curr = nums[i % n];
            while(!s.isEmpty() && s.peek() <= curr){
                s.pop();
            }
            if(i < n && !s.isEmpty()){
                ans[i] = s.peek();
            }
            s.push(curr);
        }
        return ans;
    }
}