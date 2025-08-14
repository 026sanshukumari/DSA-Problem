class Solution {
    public int[] beautifulArray(int n) {
        return beaArray(n);
    }
    private static int[] beaArray(int n){
        if(n == 1) return new int[]{1};
        int[] odds = beaArray((n+1)/2);
        int[] even = beaArray(n/2);
        int result[] = new int[n];
        int idx = 0;
        for(int x : odds) result[idx++] = 2 * x - 1;
        for(int x : even) result[idx++] = 2 * x;
        return result;
    }
}