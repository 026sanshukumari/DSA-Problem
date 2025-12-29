class Solution {
    public int[][] generateMatrix(int n ) {
        int matrix[][] = new int[n][n];
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;

        int num = 1;

        while(top <= bottom && left <= right){
            //up
            for(int i = left; i<= right; i++){
                matrix[top][i] = num++;
            }
            //right
            for(int j = top+1; j<=bottom; j++){
                matrix[j][right] = num++;
            }
            //bottom
            if(top < bottom){
            for(int j= right-1; j>=left; j--){
                matrix[bottom][j] = num++;
            }
            }
            //left
            if(left < right){
            for(int i=bottom-1; i>top; i--){
                matrix[i][left] = num++;
            }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return matrix;
    }
}