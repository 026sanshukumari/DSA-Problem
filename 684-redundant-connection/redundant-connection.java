class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            if(isCycle(n, adj)) {
                return edge; 
            }
        }

        return new int[0];
    }

    private boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            if(!vis[i]) {
                if(bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1});
        vis[start] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for(int nei : adj.get(node)) {
                if(!vis[nei]) {
                    vis[nei] = true;
                    q.add(new int[]{nei, node});
                }
                else if(nei != parent) {
                    return true; 
                }
            }
        }
        return false;
    }
}