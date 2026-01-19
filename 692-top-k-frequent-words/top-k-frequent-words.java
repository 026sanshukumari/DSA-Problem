class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) ->{
            if(!map.get(a).equals(map.get(b)))
            return map.get(b) - map.get(a);
            return a.compareTo(b);
        }
        );
        maxHeap.addAll(map.keySet());
        List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            res.add(maxHeap.poll());
        }
        return res;
    }
}