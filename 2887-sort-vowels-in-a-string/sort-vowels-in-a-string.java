class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[128];
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                freq[ch]++;
            }
        }
        char[] arr = s.toCharArray();
        int ascii = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                while (ascii < 128 && freq[ascii] == 0) {
                    ascii++;
                }                
                arr[i] = (char) ascii;
                freq[ascii]--;
            }
        }       
        return new String(arr);
    }   
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
