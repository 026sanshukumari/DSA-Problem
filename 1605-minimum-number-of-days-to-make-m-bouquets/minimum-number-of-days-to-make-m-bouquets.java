class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int day : bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            int bouquet = 0;
            int consective = 0;
            for(int day : bloomDay){
                if(day <= mid){
                    consective++;
                }else{
                    consective = 0;
                }
                if(consective == k){
                    bouquet++;
                    consective = 0;
                }
            }
                if(bouquet >= m){
                    high = mid - 1;
                }else{
                    low = mid + 1;
            }
        }
        return low;
    }
}