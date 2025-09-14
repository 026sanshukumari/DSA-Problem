public class Solution {
    public int lengthOfLastWord(String s) {
        boolean found = false;   
        int count = 0;          
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                found = true;
            } else if (found) {
                break;
            }
        }
        return count;
    }
}
