class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int count_ = 0;
        for(int i=0; i<moves.length(); i++){
            char ch = moves.charAt(i);
            if(moves.charAt(i) == 'L'){
                countL++;
            }else if(moves.charAt(i) == 'R'){
                countR++;
            }else{
                count_++;
            }
        }
        return Math.abs(countR - countL) + count_;
    }
}