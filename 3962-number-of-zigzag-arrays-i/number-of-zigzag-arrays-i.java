class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[][] up = new long[n + 1][m + 1];
        long[][] down = new long[n + 1][m + 1];

        for (int v = 1; v <= m; v++) {
            up[2][v] = v - 1;    
            down[2][v] = m - v;  
        }

        for (int len = 3; len <= n; len++) {

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefUp[v] = (prefUp[v - 1] + up[len - 1][v]) % MOD;
                prefDown[v] = (prefDown[v - 1] + down[len - 1][v]) % MOD;
            }

            for (int v = 1; v <= m; v++) {

                up[len][v] = prefDown[v - 1];

                down[len][v] =
                        (prefUp[m] - prefUp[v] + MOD) % MOD;
            }
        }

        long ans = 0;

        if (n == 2) {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[2][v] + down[2][v]) % MOD;
            }
        } else {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[n][v] + down[n][v]) % MOD;
            }
        }

        return (int) ans;
    }
}