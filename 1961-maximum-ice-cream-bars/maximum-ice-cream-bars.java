class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<costs.length; i++){
            max = Math.max(max, costs[i]);
        }
        int[] freq = new int[max + 1];
        for(int i=0; i<costs.length; i++){
            freq[costs[i]]++;
        }
        int count = 0;
        for(int i=1; i<freq.length; i++){
               int buy = Math.min(freq[i], coins/i);
               count += buy;
               coins -= buy * i;
        }
        return count;
    }
}