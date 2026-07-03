class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        return helper(n-1, m-1, grid, dp);
    }
    private int helper(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int top = helper(i-1, j, grid, dp);
        int left = helper(i, j-1, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(top, left);
        return dp[i][j];
    }
}