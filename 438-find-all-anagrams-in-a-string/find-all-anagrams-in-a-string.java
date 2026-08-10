class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }
        for(int right = 0; right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if(right - left + 1 == p.length()){
                if(map.equals(pmap)){
                    ans.add(left);
                }
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }
        return ans;
    }
}