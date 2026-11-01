class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(n,m, s,p,dp);
    }
    public boolean helper(int i, int j, String s, String p, int[][] dp){
        if(i == 0 && j == 0) return true;
        if(j == 0) return false;
        if(i == 0){
            for(int ii=1; ii<=j; ii++){
                if(p.charAt(ii-1) != '*'){
                    return false;
                }
            }
                return true;
            }
            if(dp[i][j] != -1){
                return dp[i][j] == 1;
            }
            if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                dp[i][j] = helper(i - 1, j-1,s,p,dp) ? 1 : 0;
            }
            else if(p.charAt(j-1) == '*'){
                dp[i][j] =  helper(i - 1, j, s, p,dp) || helper(i, j-1,s,p,dp) ? 1 : 0;
        }else{
        dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}