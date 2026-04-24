class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int l = 0;
        int count = 0;
        int ans = 0;
        for(int r=0; r<n+k-1; r++){
            if(r > 0 && colors[(r-1+n)%n] != colors[r%n]){
                count++;
            }
            if(r - l + 1 == k){
                if(count == k-1){
                    ans++;
                }
                if(colors[l%n] != colors[(l+1) % n]){
                    count--;
                }
                l++;
            }
        }
        return ans;
    }
}