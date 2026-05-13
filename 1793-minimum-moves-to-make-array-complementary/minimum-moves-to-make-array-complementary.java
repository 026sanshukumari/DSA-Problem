class Solution {
    public int minMoves(int[] nums, int limit) {
        int lMax = 2 * limit + 2;
        int[] diff = new int[lMax];
        for(int i=0; i<nums.length/2; i++){
            int a = nums[i];
            int b = nums[nums.length - i - 1];

            int min = 1 + Math.min(a, b);
            int max = limit + Math.max(a, b);

            int sum = a + b;

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            diff[min] -= 1;
            diff[max + 1] += 1; 

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = diff[2];
        for(int i=3; i<diff.length - 1; i++){
            diff[i] = diff[i] + diff[i - 1];
            ans = Math.min(ans, diff[i]);
        }
        return ans;
    }
}