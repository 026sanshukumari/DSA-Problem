class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int Totgas = 0, Totcost = 0;
       //Unique solution always exits
       int start = 0, currGas = 0;
       for(int i=0; i<gas.length; i++){
        Totgas += gas[i];
        Totcost += cost[i];
        currGas += (gas[i] - cost[i]);
        if(currGas < 0){
            start = i + 1;
            currGas = 0;
        }
       }
       if(Totgas < Totcost){
        return -1;
       }
       return start;
    }
}