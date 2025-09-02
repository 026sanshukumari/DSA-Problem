class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right =0;
        for(int q : quantities){
            right = Math.max(right,q);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(quantities,n,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
            return left;
    }
    private boolean isFeasible(int[] quantities, int n, int maxStore){
        int storeNeeded = 0;
        for(int q : quantities){
            storeNeeded += (q + maxStore - 1)/maxStore;
        }
        return storeNeeded <= n;
    }
}