class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int col[] = new int[n];
        Arrays.fill(col,-1);

        for(int i=0; i<n; i++){
            if(col[i] == -1){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        col[i] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : graph[curr]){
                if(col[neigh] == -1){
                    col[neigh] = 1 - col[curr];
                    q.add(neigh);
                }else if(col[neigh] == col[curr]){
                    return false;
                }
            }
        }
     }
}
        return true;
    }
}