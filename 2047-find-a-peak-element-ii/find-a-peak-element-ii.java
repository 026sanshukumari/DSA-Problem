class Solution {

    public int findMax(int[][] mat, int n, int m, int col) {
        int maxval = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxval) {
                maxval = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int start = 0, end = m - 1;  

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int maxRow = findMax(mat, n, m, mid);

            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } else if (mat[maxRow][mid] < left) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
