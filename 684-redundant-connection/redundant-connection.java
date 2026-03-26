import java.util.*;

class Solution {

    class Pair {
        int first, second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            if(isCycle(n, adj)){
                return edge;
            }
        }
        return new int[0];
    }

    private boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(!vis[i]){
                if(bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,-1));
        vis[start] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.first;
            int parent = curr.second;

            for(int adjNode : adj.get(node)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                }
                else if(parent != adjNode){
                    return true;
                }
            }
        }
        return false;
    }
}