class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int cnt = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt++;
            }
            if(right - left + 1 == k){
                max = Math.max(max, cnt);
                char chleft = s.charAt(left);
                if(chleft == 'a' || chleft == 'e' || chleft == 'i' || chleft == 'o' || chleft == 'u'){
                cnt--;
                }
                left++;
            }
        }
        return max;
    }
}