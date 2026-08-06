class Solution {
    public int lengthOfLastWord(String s) {
        String[] word = s.trim().split("\\s+");
        for(int i=word.length - 1; i>=0; i--){
            return word[i].length();
        }
        return word[word.length - 1].length();
    }
}