class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<stones.length; i++){
            pq.add(stones[i]);
        }
        while(!pq.isEmpty()){            
             x = pq.poll();
            if(!pq.isEmpty()){
             y = pq.poll();
            }
            else{
                return x;
            }
            if(x == y){
                pq.add(0);
                ans = 0;
            }else{
                pq.add(x - y);
                ans = x - y;
            }
        }
        return ans;
    }
}