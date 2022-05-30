class Solution {
    private static final int iMax = (int) (1e9);
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] curr_ans = new int[m][n];
        for (int[] arr : curr_ans) Arrays.fill(arr, iMax);
        curr_ans[0][0] = 0;
        Comparator<int[]> myComp = (o1, o2) -> (o1[2] - o2[2]);
        Queue<int[]> pq = new PriorityQueue<>(myComp);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            if (front[0] == m - 1 && front[1] == n - 1) return front[2];
            for (int k = 0; k < 4; k++) {
                int r = front[0] + dir[k][0], c = front[1] + dir[k][1];
                if (r < 0 || r >= m || c < 0 || c >= n) continue;
                int cost = front[2] + grid[r][c];
                if (cost < curr_ans[r][c]) {
                    curr_ans[r][c] = cost;
                    pq.offer(new int[]{r, c, cost});
                }
            }
        }
        
        return -1;
    }
}