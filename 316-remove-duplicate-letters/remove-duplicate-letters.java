class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(set.contains(ch)){
                continue;
            }
            while(ans.length() > 0 && ans.charAt(ans.length() -1) > ch
                 && freq[ans.charAt(ans.length() - 1) - 'a'] > 0){
                    char last = ans.charAt(ans.length() - 1);
                    ans.deleteCharAt(ans.length() - 1);
                    set.remove(last);
                 }
                 ans.append(ch);
                 set.add(ch);
        }
        return ans.toString();
        
    }
}