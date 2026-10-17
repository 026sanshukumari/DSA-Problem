class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[26];
        int left = 0;
        int cnt = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                freq[s.charAt(left) - 'a']--;
                left++;
                cnt += s.length() - right;
            }
            
        }
        return cnt;
    }
}