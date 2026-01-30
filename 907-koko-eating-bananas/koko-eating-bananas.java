class Solution {

    private long getHour(int[] piles, int k) {
        long hr = 0;
        for (int p : piles) {
            hr += (p + k - 1L) / k;   
        }
        return hr;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int ans = high;   

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHr = getHour(piles, mid);

            if (totalHr <= h) {
                ans = mid;        
                high = mid - 1;  
            } else {
                low = mid + 1;    
            }
        }

        return ans;
    }
}
