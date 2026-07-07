class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int row=0; row <numRows; row++){
            List<Integer> curr = new ArrayList<>();
            for(int col=0; col<= row; col++){
                if(col == 0 || col == row){
                    curr.add(1);
                }else{
                    int left = res.get(row-1).get(col-1);
                    int right = res.get(row-1).get(col); 

                    curr.add(left + right);
                }
            }
            res.add(curr);
        }
        return res;
    }
}