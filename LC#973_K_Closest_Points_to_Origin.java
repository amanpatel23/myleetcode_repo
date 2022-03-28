class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            int dist = (x * x) + (y * y);
            pq.offer(new int[]{i, dist});
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[pq.poll()[0]];
        }
        
        return result;
    }
}