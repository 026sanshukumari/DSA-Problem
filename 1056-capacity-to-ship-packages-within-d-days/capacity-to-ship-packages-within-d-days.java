class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }
        while(low <= high){
            int mid = low + (high - low)/2;

            int dayneeded = 1;
            int currweight = 0;
            for(int weight : weights){
                if(currweight + weight > mid){
                    dayneeded++;
                    currweight = weight; 
                }else{
                    currweight += weight;
                }
            }
            if(dayneeded > days){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}