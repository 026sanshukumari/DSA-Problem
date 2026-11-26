class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] sorted = new int[n][2];

        for(int i=0; i<n; i++){
            sorted[i][0] = intervals[i][0];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (a,b) -> Integer.compare(a[0],b[0]));
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            int end = intervals[i][1];
            
            int idx = -1;
            int left = 0;
            int right = n - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(sorted[mid][0] >= end){
                    idx = sorted[mid][1];
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            ans[i] = idx;
        }
        return ans;
    }
}