class Solution {
    class Pair implements Comparable<Pair> {
        int v;
        int cost;
        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean vis[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost = 0;
        int edgesUsed = 0;
        while(edgesUsed < n){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;
                edgesUsed++;
                for(int i=0; i<n; i++){
                    if(!vis[i]){
                        int dist = Math.abs(points[curr.v][0] - points[i][0]) + Math.abs(points[curr.v][1] - points[i][1]);
                        pq.add(new Pair(i,dist));
                    }
                }
            }
        }
            return finalCost;
        }
}