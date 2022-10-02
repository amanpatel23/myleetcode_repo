class Solution {
    public int maxSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int max = -1;
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                int curr = 0;
                for (int ii = i; ii <= i + 2; ii++) {
                    for (int jj = j; jj <= j + 2; jj++) {
                        curr += grid[ii][jj];
                    }
                }
                curr -= grid[i + 1][j];
                curr -= grid[i + 1][j + 2];
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}