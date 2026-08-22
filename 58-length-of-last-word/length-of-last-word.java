class Solution {
    public int lengthOfLastWord(String s) {
        int maxLen = 0;
        for(int i=s.length() -1; i>=0; i--){
            if(s.charAt(i) == ' ' && maxLen == 0){
                continue;
            }
            if(s.charAt(i) == ' '){
                break;
            }else{
                maxLen++;
            }
        }
        return maxLen;
    }
}