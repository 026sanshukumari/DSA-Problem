class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        int i = num1.length() - 1;
        while(i >= 0){
            int j = num2.length() - 1;
            while(j >= 0){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int sum = a * b + res[i + j + 1];
                int carry = sum / 10;
                int digit = sum % 10;
                res[i + j + 1] = digit;
                res[i + j] += carry;
                j--;
            }
            i--;
        }
        StringBuilder ans = new StringBuilder();
        for(int num : res){
            if(ans.length() == 0 && num == 0){
               continue;
            }
             ans.append(num);
        }
        return ans.toString();
    }
}