class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        // int n = nums.length;
        // if (k == 1) return nums.clone();

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        //1st wind
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k; i<n; i++){
            res[idx++] = nums[dq.getFirst()];

            //remove elmet not part of curr wind
            while(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.removeFirst();
            }
            //remove the smaller vals
              while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        res[idx] = nums[dq.getFirst()];
        return res;
    }
}