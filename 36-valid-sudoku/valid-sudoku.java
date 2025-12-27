class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;
                if(!set.add(ch + "in row" + i) || 
                   !set.add(ch + "in col" + j) ||
                   !set.add(ch + "in box" + (i/3) + "_" + (j/3))){
                    return false;
                   }
            }
        }
        return true;
    }
}
