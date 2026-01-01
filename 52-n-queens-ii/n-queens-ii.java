class Solution {
    private static boolean isSafe(boolean board[][], int row, int col){
        //col
        for(int i=row-1; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        //left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
    private int nQueen(boolean[][] board, int row){
        int n = board.length;
        if(row == n){
            return 1; 
        }
        int count = 0;
        for(int col=0; col<n; col++){
           if(isSafe(board, row, col)){
                board[row][col] = true;
                count += nQueen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        int count = nQueen(board, 0);
        return count;
    
    }
}