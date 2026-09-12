class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        String ans = "";

        for (int f = maxFreq; f >= 1; f--) {

            for (int i = 0; i < freq.length; i++) {

                if (freq[i] == f) {
                    char ch = (char) i;

                    for (int j = 0; j < f; j++) {
                        ans += ch;
                    }
                }
            }
        }

        return ans;
    }
}