class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();

        int[] right = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        long max = 0;
        for(int i = 0; i < n; i++) {
            long sum = prefix[right[i]] - prefix[left[i] + 1];
            long product = sum * nums[i];
            max = Math.max(max, product);
        }

        return (int)(max % 1000000007);
    }
}