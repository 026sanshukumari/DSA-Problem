class Solution {

    public int calNextIdx(int[] nums, int curr) {
        int next = curr;
        int seq = nums[curr];

        if (seq > 0) {
            next = (curr + seq) % nums.length;
        } else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }
        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;

            boolean isPos = nums[i] > 0;
            int slow = i;
            int fast = i;

            do {
                slow = calNextIdx(nums, slow);

                // direction check for slow
                if (isPos && nums[slow] < 0) break;
                if (!isPos && nums[slow] > 0) break;

                fast = calNextIdx(nums, fast);
                if (isPos && nums[fast] < 0) break;
                if (!isPos && nums[fast] > 0) break;

                fast = calNextIdx(nums, fast);
                if (isPos && nums[fast] < 0) break;
                if (!isPos && nums[fast] > 0) break;

                if (slow == fast) {
                    // k > 1 (no self-loop)
                    if (slow != calNextIdx(nums, slow)) {
                        return true;
                    }
                    break;
                }

            } while (slow != fast);

            // cleanup visited path
            int idx = i;
            if (isPos) {
                while (nums[idx] > 0) {
                    int next = calNextIdx(nums, idx);
                    nums[idx] = 0;
                    idx = next;
                }
            } else {
                while (nums[idx] < 0) {
                    int next = calNextIdx(nums, idx);
                    nums[idx] = 0;
                    idx = next;
                }
            }
        }
        return false;
    }
}
