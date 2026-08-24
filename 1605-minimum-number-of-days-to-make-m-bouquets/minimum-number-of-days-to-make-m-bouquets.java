class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = bloomDay[0];
        int right = bloomDay[0];

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int flower = 0;
            int bouquet = 0;

            for (int i = 0; i < bloomDay.length; i++) {

                if (bloomDay[i] <= mid) {
                    flower++;

                    if (flower == k) {
                        bouquet++;
                        flower = 0;
                    }

                } else {
                    flower = 0;
                }
            }

            if (bouquet >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}