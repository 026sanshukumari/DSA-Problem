class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int reverseval = 26 - (ch - 'a');
            int product = reverseval * (i + 1);
            sum = sum + product; 
        }
        return sum;
    }
}