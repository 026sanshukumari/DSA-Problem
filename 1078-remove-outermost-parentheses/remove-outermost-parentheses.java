class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int depth = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(depth > 0){
                    ans.append(ch);
                }
                depth++;
            }else{
                depth--;
                if(depth > 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}