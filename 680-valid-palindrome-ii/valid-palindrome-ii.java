class Solution {
    private boolean helper(int left, int right, String s){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right){
               return helper(i+1, j, s) || helper(i, j-1,s);
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}