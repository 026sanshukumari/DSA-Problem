class Solution {
    public int repeatedStringMatch(String a, String b) {
        String repeat = "";
        int count = (b.length() + a.length() - 1) / a.length();
        for(int i=0; i<count; i++){
            repeat = repeat + a;
        }
            if(repeat.contains(b)){
                return count;
            }
            repeat = repeat + a;
            if(repeat.contains(b)){
                return count + 1;
        }
        return -1;
    }
}