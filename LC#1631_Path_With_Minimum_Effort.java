class Solution {
    
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final int iMax = (int) (1e9);
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int[][] min_effort_grid = new int[m][n];
        for (int[] r : min_effort_grid) Arrays.fill(r, iMax);
        min_effort_grid[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int r = top[0], c = top[1], e = top[2];
            if (r == (m - 1) && c == (n - 1)) return min_effort_grid[r][c];
            if (min_effort_grid[r][c] < e) continue;
            for (int i = 0; i < 4; i++) {
                int r_new = r + dir[i][0], c_new = c + dir[i][1];
                if (r_new >= m || r_new < 0 || c_new >= n || c_new < 0) continue;
                int e_new = Math.max(e, 
                                     Math.abs(heights[r][c] - heights[r_new][c_new]));
                if (min_effort_grid[r_new][c_new] > e_new) {
                    min_effort_grid[r_new][c_new] = e_new;
                    pq.offer(new int[]{r_new, c_new, e_new});
                }
            }
        }
        
        return -1;
    }
}