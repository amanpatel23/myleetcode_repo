class Solution {
    
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int[][] mygrid;
    private static int n;
    public int regionsBySlashes(String[] grid) {
        
        n = grid.length;
        mygrid = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == ' ') continue;
                else if (grid[i].charAt(j) == '/') {
                    int r = 3 * i, c = (3 * j) + 2;
                    for (int cnt = 0; cnt < 3; cnt++) {
                        mygrid[r][c] = 1;
                        r++;
                        c--;
                    }
                }else {
                    int r = 3 * i, c = 3 * j;
                    for (int cnt = 0; cnt < 3; cnt++) {
                        mygrid[r][c] = 1;
                        r++;
                        c++;
                    }
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < (3 * n); i++) {
            for (int j = 0; j < (3 * n); j++) {
                if (mygrid[i][j] == 0) {
                    result++;
                    dfs(i, j);
                }
            }
        }
        
        return result;
    }
    
    private static void dfs(int i, int j) {
        
        if (i < 0 || i >= (3 * n) || j < 0 || j >= (3 * n) || mygrid[i][j] == 1) 
            return;
        
        mygrid[i][j] = 1;
        for (int k = 0; k < 4; k++) 
            dfs(i + dir[k][0], j + dir[k][1]);
    }
}