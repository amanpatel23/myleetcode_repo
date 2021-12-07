class Solution {
    
    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(seen[i], -1);
        
        Queue<int[]> qq = new LinkedList<>();
        qq.offer(new int[]{0, 0, k});
        seen[0][0] = k;
        
        int steps = 0;
        while (!qq.isEmpty()) {
            int _size = qq.size();
            while (_size-- > 0) {
                int[] curr = qq.poll();
                if (curr[0] == m - 1 && curr[1] == n - 1)
                    return steps;
                
                for (int i = 0; i < 4; i++) {
                    int x = curr[0] + dir[i][0];
                    int y = curr[1] + dir[i][1];
                    
                    if (x >= m || x < 0 || y >= n || y < 0)
                        continue;
                    
                    int left = curr[2] - grid[x][y];
                    if (seen[x][y] < left) {
                        seen[x][y] = left;
                        qq.offer(new int[]{x, y, left});
                    }
                }
            }
            
            steps += 1;
        }
        
        return -1;
    }
}