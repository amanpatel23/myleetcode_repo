class Solution {
    
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int m, n;
    public int minimumEffortPath(int[][] heights) {
        
        m = heights.length; n = heights[0].length;
        int l = 0, r = (int) (1e6);
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(mid, heights)) r = mid;
            else l = mid;
        }
        
        if (check(l, heights)) return l;
        else return r;
    }
    
    private static boolean check(int x, int[][] heights) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, visited, 0, heights, x);
    }
    
    private static boolean dfs(int r, int c, boolean[][] visited, int e,
                               int[][] heights, int x) {
        
        if (visited[r][c] || e > x) return false;
        if (r == (m - 1) && c == (n - 1)) return true;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int r_new = r + dir[i][0], c_new = c + dir[i][1];
            if (r_new >= m || r_new < 0 || c_new >= n || c_new < 0) continue;
            int e_new = Math.abs(heights[r][c] - heights[r_new][c_new]);
            if (dfs(r_new, c_new, visited, e_new, heights, x)) return true;
        }
        
        return false;
    }
}