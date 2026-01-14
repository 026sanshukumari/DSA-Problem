class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int i = 0; i < points.length; i++) {
            int distSq = points[i][0] * points[i][0]
                       + points[i][1] * points[i][1];
            pq.add(new int[]{distSq, points[i][0], points[i][1]});
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] temp = pq.poll();
            result[i][0] = temp[1];
            result[i][1] = temp[2];
        }

        return result;
    }
}
