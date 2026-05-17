class Solution {
    public int countKthRoots(int l, int r, int k) {
        int left = (int)Math.floor(Math.pow(l, 1.0/k));
        int right = (int)Math.ceil(Math.pow(r, 1.0/k));


        int validLeft = Math.pow(left, k) >= l ? left : left+1;
        int validRight = Math.pow(right, k) <= r? right: right-1;

        return validRight-validLeft+1;
        
    }
}

