class Solution {
    public int numberOfSpecialChars(String word) {
       int[] small = new int[26];
       int[] capital = new int[26];
       Arrays.fill(small, -1);
       Arrays.fill(capital, -1);
       for(int i=0; i<word.length(); i++){
        char ch = word.charAt(i);
        if(ch >= 'a' && ch <= 'z'){
            small[ch - 'a'] = i;
        }
        else if(ch >= 'A' && ch <= 'Z'){
            int idx = ch - 'A';
            if(capital[idx] == -1){
                capital[idx] = i;
            }
        }
       }
       int count = 0;
       for(int ch=0; ch<26; ch++){
        if(small[ch] != -1 && capital[ch] != -1 && small[ch] < capital[ch]){
            count++;
        }
       }
       return count;
    }
}