class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int layers = Math.min(n, m) / 2;

        for(int layer = 0; layer < layers; layer++) {

            int top = layer;
            int left = layer;
            int bottom = n - layer - 1;
            int right = m - layer - 1;

            ArrayList<Integer> val = new ArrayList<>();

            // top
            for(int j = left; j <= right; j++)
                val.add(grid[top][j]);

            // right
            for(int i = top + 1; i <= bottom; i++)
                val.add(grid[i][right]);

            // bottom
            for(int j = right - 1; j >= left; j--)
                val.add(grid[bottom][j]);

            // left
            for(int i = bottom - 1; i > top; i--)
                val.add(grid[i][left]);

            int sz = val.size();
            int rot = k % sz;

            ArrayList<Integer> rotated = new ArrayList<>();

            for(int i = 0; i < sz; i++) {
                rotated.add(val.get((i + rot) % sz));
            }

            int idx = 0;

            // top
            for(int j = left; j <= right; j++)
                grid[top][j] = rotated.get(idx++);

            // right
            for(int i = top + 1; i <= bottom; i++)
                grid[i][right] = rotated.get(idx++);

            // bottom
            for(int j = right - 1; j >= left; j--)
                grid[bottom][j] = rotated.get(idx++);

            // left
            for(int i = bottom - 1; i > top; i--)
                grid[i][left] = rotated.get(idx++);
        }

        return grid;
    }
}