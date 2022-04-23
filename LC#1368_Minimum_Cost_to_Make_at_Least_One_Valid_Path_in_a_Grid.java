class Solution {
    
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int iMax = (int) (1e9);
    public int minCost(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        pq.offer(new int[]{0, 0, 0});
        int[][] cost = new int[m][n];
        for (int[] r : cost) Arrays.fill(r, iMax);
        cost[0][0] = 0;
        boolean[][] visited = new boolean[m][n];
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if ((top[0] == m - 1) && (top[1] == n - 1)) return top[2];
            if (top[2] > cost[top[0]][top[1]]) continue;
            visited[top[0]][top[1]] = true;
            int curr_dir = grid[top[0]][top[1]] - 1;
            for (int i = 0; i < 4; i++) {
                int r = top[0] + dir[i][0], c = top[1] + dir[i][1];
                if (r >= m || r < 0 || c >= n || c < 0) continue;
                if (visited[r][c]) continue;
                int add = (curr_dir == i ? 0 : 1);
                if (cost[r][c] > (cost[top[0]][top[1]] + add)) {
                    cost[r][c] = cost[top[0]][top[1]] + add;
                    pq.offer(new int[]{r, c, cost[top[0]][top[1]] + add});
                }
            }
        }
        
        return -1;
    }
}