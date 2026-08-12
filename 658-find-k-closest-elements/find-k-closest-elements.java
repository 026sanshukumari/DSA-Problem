class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int da = Math.abs(a - x);
            int db = Math.abs(b - x);

            if(da != db){
                return db - da;
            }else{
                return b - a;
            }
        });
        for(int num : arr){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}