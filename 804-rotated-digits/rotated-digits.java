class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int x = i;

            boolean valid = true;
            boolean change = false;

            while (x > 0) {
                int d = x % 10;

                // invalid digit
                if (d == 3 || d == 4 || d == 7) {
                    valid = false;
                    break;
                }

                // good rotating digit
                if (d == 2 || d == 5 || d == 6 || d == 9) {
                    change = true;
                }

                x /= 10;
            }

            if (valid && change) {
                count++;
            }
        }

        return count;
    }
}