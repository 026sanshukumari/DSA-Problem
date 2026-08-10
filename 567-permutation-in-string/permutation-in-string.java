class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            pmap.put(s1.charAt(i),pmap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int right=0; right<s2.length(); right++){
            map.put(s2.charAt(right), map.getOrDefault(s2.charAt(right), 0) + 1);
            if(right - left + 1 == s1.length()){
                if(map.equals(pmap)){
                    return true;
                }
                char ch = s2.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            left++;
        }
        }
        return false;

    }
}