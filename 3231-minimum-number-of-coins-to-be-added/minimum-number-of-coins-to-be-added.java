class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        long reach = 0;
        int i = 0;
       while(reach < target){
            if(i < coins.length && coins[i] <= reach + 1){
                reach = reach + coins[i];
                i++;
            }else{
                reach = reach + (reach + 1);
                count++;
            }
        }
        return count;
    }
}