class Solution {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegrees = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int r = i + dir[k][0], c = j + dir[k][1];
                    if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] >= matrix[i][j])
                        continue;
                    indegrees[i][j]++;
                }
            }
        }
        
        int ans = 0;
        Queue<int[]> qq = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegrees[i][j] == 0) qq.offer(new int[]{i, j});
            }
        }
        
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                int[] front = qq.poll();
                int r = front[0], c = front[1];
                for (int[] d : dir) {
                    int r_new = r + d[0], c_new = c + d[1];
                    if (r_new < 0 || r_new >= m || c_new < 0 || c_new >= n || 
                       matrix[r_new][c_new] <= matrix[r][c]) continue;
                    if (--indegrees[r_new][c_new] == 0) qq.offer(new int[]{r_new, c_new});
                }
            }
            ans++;
        }
        
        return ans;
    }
}