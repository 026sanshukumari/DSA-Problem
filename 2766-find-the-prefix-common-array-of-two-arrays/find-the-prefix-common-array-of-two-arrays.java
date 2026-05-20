class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] seenA = new boolean[n+1];
        boolean[] seenB = new boolean[n+1];

        int count = 0;
        for(int i=0; i<n; i++){
            int a = A[i];
            int b = B[i];

            seenA[a] = true;
            seenB[b] = true;

            if(seenB[a]) count++;
            if(a != b && seenA[b]) count++;
            ans[i] = count;
        }
        return ans;
    }
}