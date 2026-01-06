class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        String normalizedPatt = normalize(pattern);
        for(String word : words){
            if(word.length() != pattern.length()){
                continue;
            }
            if(normalize(word).equals(normalizedPatt)){
                res.add(word);
            }
        }
        return res;
    }
    private String normalize(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int id = 0;
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,id++);
            }
            sb.append(map.get(c)).append("#");
        }
        return sb.toString();
    }
}