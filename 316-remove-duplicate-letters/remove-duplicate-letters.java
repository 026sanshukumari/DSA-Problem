class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        StringBuilder res = new StringBuilder();

        for(int i=0; i<n; i++){
        char currChar = s.charAt(i);

        freq[currChar - 'a'] --;

        if(used[currChar - 'a']) continue;

        //greedy

        while (res.length() > 0 &&
                   res.charAt(res.length() - 1) > currChar &&
                   freq[res.charAt(res.length() - 1) - 'a'] > 0) {

                char lastChar = res.charAt(res.length() - 1);
                res.deleteCharAt(res.length() - 1);
                used[lastChar - 'a'] = false;
            }
            res.append(currChar);
            used[currChar - 'a'] = true;
        }
         return res.toString();
    }
}