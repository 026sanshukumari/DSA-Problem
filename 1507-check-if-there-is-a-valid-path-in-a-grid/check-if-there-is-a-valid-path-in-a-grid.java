class Solution {
    public boolean hasValidPath(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        q.add(new int[]{0,0});
        vis[0][0] = true;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            if(i == n-1 && j == m-1) return true;
            int type = grid[i][j];

            //Left
            if(j-1 >= 0 && !vis[i][j-1] &&
              (type == 1 || type == 3 || type == 5) &&
               (grid[i][j-1] == 1 || grid[i][j-1] == 4 || 
               grid[i][j-1] == 6)){
                vis[i][j-1] = true;
                q.add(new int[] {i,j-1});
               }
               //Right
               if(j+1 < m && !vis[i][j+1] &&
               (type == 1 || type == 4 || type == 6) && 
               (grid[i][j+1] == 1 || grid[i][j+1] == 3 ||
               grid[i][j+1] == 5)){
                vis[i][j+1] = true;
                q.add(new int[]{i,j+1});
               }
               //up
               if(i-1 >= 0 && !vis[i-1][j] &&
               (type == 2 || type == 5 || type == 6) && 
               (grid[i-1][j] == 2 || grid[i-1][j] == 3 ||
               grid[i-1][j] == 4)){
                vis[i-1][j] = true;
                q.add(new int[]{i-1,j});
               }
               //bottom
               if(i+1 < n && !vis[i+1][j] &&
               (type == 2 || type == 3 || type == 4) &&
               (grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6)){
                vis[i+1][j] = true;
                q.add(new int[]{i+1, j});
               }
        }
        return false;
    }
}