class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> s3 = new HashSet<>();
        for(int num : nums1){
            s1.add(num);
        }
        for(int num : nums2){
            s2.add(num);
        }
        for(int num : nums3){
            s3.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num : s1){
            if(s3.contains(num) || s2.contains(num)){
                ans.add(num);
            }
        }
        for(int num : s2){
            if(s3.contains(num) && !ans.contains(num)){
                ans.add(num);
            }
        }
        return ans;
    }
}