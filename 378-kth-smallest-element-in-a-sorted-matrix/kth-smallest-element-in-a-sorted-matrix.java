class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
                      matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i=0; i<matrix.length; i++){
            if(matrix[i].length > 0){
               pq.add(new int[]{i, 0});
            }
        }
        int count = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];
            count++;
            
            if(count == k){
                return matrix[row][col];
            }

            if(col + 1 < matrix[row].length){
                pq.add(new int[]{row,col+1});
            }
        }
        return -1;
    }
}