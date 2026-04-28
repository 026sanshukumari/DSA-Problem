class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int ref = grid[0][0] % x;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] % x != ref){
                    return -1;
                }
            }
        }
        int[] arr = new int[n * m];
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int tar = arr[arr.length/2];
        int countOpr = 0;
        for(int val : arr){
            countOpr += Math.abs(val - tar) /x;
        }
        return countOpr;
    }
}