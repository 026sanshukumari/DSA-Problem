import java.util.*;

class Solution {

    static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1)
            return 0;

        int[][] A = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j] = grid.get(i).get(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            int val = A[r][c];

            for(int[] d : dir){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && A[nr][nc]==0){

                    A[nr][nc] = val + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->b[0]-a[0]);

        pq.offer(new int[]{A[0][0],0,0});
        A[0][0] *= -1;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int sf = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r==n-1 && c==n-1)
                return sf-1;

            for(int[] d:dir){

                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && A[nr][nc]>0){

                    pq.offer(new int[]{
                            Math.min(sf,A[nr][nc]),nr,nc});

                    A[nr][nc] *= -1;
                }
            }
        }

        return 0;
    }
}