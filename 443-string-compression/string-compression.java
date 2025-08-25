class Solution {
    public int compress(char[] chars) {
        StringBuilder newStr = new StringBuilder();
        int i =0;
        while(i < chars.length){
            char currChar = chars[i];
            int count = 1;
            while(i+1<chars.length &&  chars[i] == chars[i+1]){
                count ++;
                i++;
            }
            newStr.append(currChar);
            if(count > 1){
                newStr.append(count);
            }
            i++;
        }
        for (int j = 0; j < newStr.length(); j++) {
            chars[j] = newStr.charAt(j);
        }
        return newStr.length();
    }
}
