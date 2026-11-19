class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length;
        int max = -1;
        int maxIdx = 0;

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
                if(cnt > max){
                    max = cnt;
                    maxIdx = i;
                }
            }
        return new int[]{maxIdx, max};
    }
}