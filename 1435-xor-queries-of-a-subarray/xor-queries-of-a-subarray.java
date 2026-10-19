class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1] ^ arr[i];
        }

        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0){
                ans[i] = prefix[end];
            }else{
                ans[i] = prefix[end] ^ prefix[start - 1];
            }
        }
        return ans;
    }
}