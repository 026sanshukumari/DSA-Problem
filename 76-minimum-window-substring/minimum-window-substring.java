class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int l = 0, r = 0;
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        while(r < s.length()){
            char c = s.charAt(r);

            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) >= 0) cnt++;
            }
            while(cnt == t.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    start = l;
                }
                char left = s.charAt(l);
                if(map.containsKey(left)){
                    map.put(left, map.get(left)+1);
                    if(map.get(left) > 0) cnt--;
                }
                l++;
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}