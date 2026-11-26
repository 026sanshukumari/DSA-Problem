class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxLen = 0;
        boolean odd = false;
        for(int freq : map.values()){
            if(freq % 2 == 0){
                maxLen += freq;
            }else{
                maxLen += freq - 1;
                odd = true;
            }
        }
        if(odd){
           maxLen++;
        }
        return maxLen;
    }
}