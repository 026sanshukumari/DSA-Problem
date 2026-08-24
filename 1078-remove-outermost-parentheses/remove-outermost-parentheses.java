class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int depth = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                depth++;
                if(depth > 1){
                    ans.append(ch);
                }
            }
                else{
                    depth--;
                    if(depth > 0){
                        ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}