class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean hasvow = false;
        boolean hascon = false;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9') continue;
            else if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                char c = Character.toLowerCase(ch);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    hasvow = true;
                }else{
                    hascon = true;
                }
            }
            else{
                return false;
            }
        }
        return hasvow && hascon;
    }
}