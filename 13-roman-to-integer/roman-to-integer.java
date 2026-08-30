class Solution {
    public int romanToInt(String s) {
       char rn; 
       int sum = 0;
       for(int i=0; i<s.length(); i++){
        rn = s.charAt(i);
        if(rn == 'I'){
            if(i + 1 < s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                sum -= 1;
            }else{
            sum += 1;
            }
         }else if(rn == 'V'){
            sum += 5;
         }else if(rn == 'X'){
            if(i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i+1) == 'C')){
                sum -= 10;
            }else{
            sum += 10;
            }
         }else if(rn == 'L'){
            sum += 50;
         }else if(rn == 'C'){
            if(i+1 < s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                sum -= 100;
            }else{
            sum += 100;
            }
         }else if(rn == 'D'){
            sum += 500;
         }else if(rn == 'M'){
            sum += 1000;
         }
       }
       return sum;
    }
}