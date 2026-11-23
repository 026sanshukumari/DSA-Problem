class Solution {
    public int secondHighest(String s) {
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int digit = ch - '0';
            if(digit > first){
                sec = first;
                first = digit;
            }else if(digit > sec && first != digit){
                sec = digit;
            }
        }
        }
        if(sec == Integer.MIN_VALUE){
            return -1;
        }
        return sec;
    }
}