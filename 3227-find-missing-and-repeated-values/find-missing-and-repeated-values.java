class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int value = grid[i][j];
                freq.put(value, freq.getOrDefault(value, 0) + 1);
            }
        }
        int[] ans = new int[2];
        for(int num=1; num <=n*n; num++){
            if(freq.getOrDefault(num,0) == 2){
                ans[0] = num;
            }
            if(!freq.containsKey(num)){
                ans[1] = num;
            }
        }
        return ans;
    }
}