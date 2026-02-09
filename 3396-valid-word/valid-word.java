class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3){
            return false;
        }
        int vowel = 0;
        int consonante = 0;
        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiouAEIOU".indexOf(c) != -1){
                     vowel++;
                       }else{
                            consonante++;
                       }
            }else if(!Character.isDigit(c)){
                return false;
            }
        }
        return vowel >= 1 && consonante >= 1;
    }
}