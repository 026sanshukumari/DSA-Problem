class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(startRow <= endRow && startCol <= endCol){
            for(int j = startCol; j <= endCol; j++){
                ans.add(matrix[startRow][j]);
                
            }
            startRow++;
           
            for(int i=startRow; i<=endRow; i++){
                ans.add(matrix[i][endCol]);
            }
            
           endCol--;
            if(startRow<=endRow){
            for(int j=endCol; j>=startCol; j--){
               
                ans.add(matrix[endRow][j]);
            }
            endRow=endRow-1;
            }
            if(startCol<=endCol){
        for(int i=endRow; i>=startRow; i--){
           
            ans.add(matrix[i][startCol]);
        }
        startCol++;
            }

       
        }
        return ans;
    }
}