class Solution {
    class Pair implements Comparable<Pair> {
        int count;
        char ch;

        Pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
        public int compareTo(Pair that) {
            return that.count - this.count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        if (a > 0) pq.offer(new Pair(a, 'a'));
        if (b > 0) pq.offer(new Pair(b, 'b'));
        if (c > 0) pq.offer(new Pair(c, 'c'));

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int n = res.length();

            if (n >= 2 && res.charAt(n - 1) == node.ch && res.charAt(n - 2) == node.ch) {
                if (pq.isEmpty()) break;

                Pair sec = pq.poll();
                res.append(sec.ch);
                sec.count--;

                if (sec.count > 0) {
                    pq.offer(sec);
                }

                pq.offer(node); 
            } else {
                res.append(node.ch);
                node.count--;

                if (node.count > 0) {
                    pq.offer(node);
                }
            }
        }
        return res.toString();
    }
}