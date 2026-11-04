class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;
        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        StringBuilder res = new StringBuilder();
        for(String word : words){
            if(!word.isEmpty()){
            if(res.length() > 0){
                res.append(" ");
            }
            res.append(word);
        }
        }
        return res.toString();
    }
}