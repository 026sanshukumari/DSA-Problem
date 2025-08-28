import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getFreqStr(str);  // create signature for each string

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(key, strList);
            }
        }
        return new ArrayList<>(map.values());
    }
    private String getFreqStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);  // sort characters to form key
        return new String(arr);
    }
}
