class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,nums.length,result,new ArrayList<>());
        return result;
    }
    private void helper(int nums[], int i, int n, List<List<Integer>> result, List<Integer> curr){
        if(i == n){
            result.add(new ArrayList<>(curr));
            return;
        }
        helper(nums,i+1,n,result,curr);
        curr.add(nums[i]);
        helper(nums,i+1,n,result,curr);
        curr.remove(curr.size() - 1);
    }
}

