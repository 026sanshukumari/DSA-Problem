class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0, maxLen = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch) >= l){
                    l = map.get(ch) + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len,maxLen);
            map.put(ch,r);
            r++;
        }
        return maxLen;

    }
}