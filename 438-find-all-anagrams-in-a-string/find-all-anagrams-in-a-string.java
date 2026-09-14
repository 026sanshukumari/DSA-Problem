class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        int[] freqWin = new int[26];
        for(int i=0; i < p.length(); i++){
            freq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            freqWin[s.charAt(right) - 'a']++;
            if(right - left + 1 == p.length()){
                if(Arrays.equals(freqWin, freq)){
                    ans.add(left);
                }
                freqWin[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}