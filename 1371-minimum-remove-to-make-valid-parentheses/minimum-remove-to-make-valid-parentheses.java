class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int balance = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                balance++;
                ans.append(ch);
            }else if(ch == ')'){
                if(balance > 0){
                    balance--;
                    ans.append(ch);
                }
            }else{
                ans.append(ch);
            }
        }
        for(int i=ans.length() - 1; i>=0 && balance > 0; i--){
            if(ans.charAt(i) == '('){
                ans.deleteCharAt(i);
                balance--;
            }
        }
        return ans.toString();
    }
}