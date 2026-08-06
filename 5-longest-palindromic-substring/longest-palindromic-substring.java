class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            int odd = expand(s, i, i);
            if(odd > maxLen){
                maxLen = odd;
                start = i - odd/2;
            }
            int even = expand(s, i, i+1);
            if(even > maxLen){
                maxLen = even;
                start = i - even / 2 + 1;
            }
        }
        return s.substring(start, start+maxLen);
    }
    public int expand(String s, int left, int right){
        while(left >= 0 && right < s.length()
              && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
              }
              return right - left - 1;
    }
}