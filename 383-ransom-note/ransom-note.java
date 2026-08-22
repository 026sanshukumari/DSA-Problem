class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(int i=0; i<ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            freq[ch - 'a']++;
        }
        for(int i=0; i<magazine.length(); i++){
            char ch1 = magazine.charAt(i);
            if(freq[ch1 - 'a' ] > 0){
                freq[ch1 - 'a']--;
            }
        }
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                return false;
            }
        }
        return true;
    }
}