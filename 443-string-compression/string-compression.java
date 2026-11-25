class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int write = 0;

        while(i < chars.length){
        char currchar = chars[i];
        int cnt = 0;
        while(i < chars.length && chars[i] == currchar){
            cnt++;
            i++;
        }
        chars[write++] = currchar;
        if(cnt > 1){
            for(char digit : String.valueOf(cnt).toCharArray()){
                chars[write++] = digit;
            }
        }
        }
        return write;
    }
}