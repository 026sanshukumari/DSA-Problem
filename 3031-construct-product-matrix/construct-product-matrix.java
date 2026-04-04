class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = m * n;
        int mod = 12345;

        long[] arr = new long[size];
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[k++] = grid[i][j];
            }
        }
        long[] res = new long[size];
        long prefix = 1;
        for(int i=0; i<size; i++){
            res[i] = prefix;
            prefix = (prefix * arr[i]) % mod;
        }
        long suffix = 1; 
        for(int i=size - 1; i>=0; i--){
            res[i] = (res[i] * suffix) % mod;
            suffix = (suffix * arr[i]) % mod;
        }
        int[][] ans = new int[n][m];
        k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = (int)(res[k++] % mod);
            }
        }
        return ans;
    }
}