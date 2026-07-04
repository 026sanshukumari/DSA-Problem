class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
    private int helper(int i, String s, int[] dp){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int way = 0;
        way += helper(i + 1, s, dp);

        if(i + 1 < s.length()){
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
            if(num >= 10 && num <= 26){
                way += helper(i + 2, s, dp);
            }
        }
        dp[i] = way;
        return dp[i];
    }
}