class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0;
        int start = 0;
        int total = 0;
        for(int i=0; i<gas.length; i++){
            fuel = fuel + gas[i] - cost[i];
            total = total + gas[i] - cost[i];
            if(fuel < 0){
                start = i + 1;
                fuel = 0;
            }
        }
        if(total < 0){
            return -1;
        }else{
            return start;
        }
    }
}