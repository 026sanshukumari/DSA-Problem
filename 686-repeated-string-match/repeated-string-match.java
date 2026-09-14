class Solution {
    public int repeatedStringMatch(String a, String b) {

        int count = (b.length() + a.length() - 1) / a.length();

        StringBuilder repeat = new StringBuilder();

        for(int i = 0; i < count; i++){
            repeat.append(a);
        }

        if(repeat.indexOf(b) != -1){
            return count;
        }

        repeat.append(a);

        if(repeat.indexOf(b) != -1){
            return count + 1;
        }

        return -1;
    }
}