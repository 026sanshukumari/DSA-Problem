class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character,Integer> map = new HashMap<>();
       HashMap<Character,Integer> pmap = new HashMap<>();
       for(int i=0; i<t.length(); i++){
        pmap.put(t.charAt(i), pmap.getOrDefault(t.charAt(i), 0) + 1);
       }

       int formed = 0;
       int required = pmap.size();
       int left = 0;
       int start = 0;
       int minLen = Integer.MAX_VALUE;
       for(int right = 0; right < s.length(); right++){
        char ch = s.charAt(right);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        if(pmap.containsKey(ch) && map.get(ch).equals(pmap.get(ch))){
            formed++;
        }

        while(formed == required){
            if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

            char chleft = s.charAt(left);
            map.put(chleft,map.get(chleft) - 1);
            if(pmap.containsKey(chleft) && map.get(chleft) < pmap.get(chleft)){
                formed--;
            }
            left++;
        }
       }
       if(minLen == Integer.MAX_VALUE){
        return "";
       }
       return s.substring(start , start+minLen);
    }
}