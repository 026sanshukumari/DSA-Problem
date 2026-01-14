class Point {
    int x;
    int y;
    int dist;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = x * x + y * y; 
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        for (int i = 0; i < points.length; i++) {
            pq.add(new Point(points[i][0], points[i][1]));
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }
}
