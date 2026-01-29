class Solution {

    public boolean canTransform(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long sum = 0;
        long[] diff = new long[n + 1];

        for (int i = 0; i < k; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];

            diff[start] += value;
            if (end + 1 < n) {
                diff[end + 1] -= value;
            }
        }

        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;

        if (!canTransform(nums, queries, right)) return -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canTransform(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
