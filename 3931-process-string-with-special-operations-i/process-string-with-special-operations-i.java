class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                res.append(ch);
            }
            else if(ch == '*'){
               if(res.length() > 0){
                res.deleteCharAt(res.length() - 1);
               }
            }
            else if(ch == '#'){
                res.append(res.toString());
            }
            else if(ch == '%'){
                res.reverse();
            }
        }
        return res.toString();
    }
}