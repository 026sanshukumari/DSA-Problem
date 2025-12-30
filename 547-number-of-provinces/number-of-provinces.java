class Solution {
        private static void dfs(int node, int[][] isConnected, int[] vis) {
            vis[node] = 1;
            for(int i=0; i<isConnected.length; i++){
                if(isConnected[node][i] == 1 && vis[i] == 0){
                    dfs(i, isConnected, vis);
                }
            }
        }
        public int findCircleNum(int[][] isConnected) {
            int V = isConnected.length;
            int[] vis = new int[V];
            int cnt = 0;
            for(int i=0; i<V; i++){
                if(vis[i] == 0){
                    cnt++;
                    dfs(i, isConnected, vis);
            }
        }
        return cnt;
    }
}