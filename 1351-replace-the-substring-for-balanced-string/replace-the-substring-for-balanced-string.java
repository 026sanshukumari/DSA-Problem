class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int required = n / 4;

        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        if (count['Q'] == required &&
            count['W'] == required &&
            count['E'] == required &&
            count['R'] == required) {
            return 0;
        }

        int left = 0;
        int ans = n;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right)]--;

            while (left < n &&
                   count['Q'] <= required &&
                   count['W'] <= required &&
                   count['E'] <= required &&
                   count['R'] <= required) {

                ans = Math.min(ans, right - left + 1);
                count[s.charAt(left)]++;
                left++;
            }
        }

        return ans;
    }
}
