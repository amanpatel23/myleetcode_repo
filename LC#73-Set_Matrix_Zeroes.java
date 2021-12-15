class Solution {
    
    private static int m, n;
    public void setZeroes(int[][] matrix) {
        
        m = matrix.length;
        n = matrix[0].length;
        solve(matrix, 0, 0);
    }
    
    private static void solve(int[][] matrix, int i, int j) {
        if (i >= m)
            return;
        
        boolean isZero = (matrix[i][j] == 0);
        int _i = i;
        int _j = j + 1;
        if (_j >= n) {
            _i = i + 1;
            _j = 0;
        }
        solve(matrix, _i, _j);
        
        if (isZero)
            util(matrix, i, j);
    }
    
    private static void util(int[][] matrix, int r, int c) {
        for (int j = 0; j < n; j++)
            matrix[r][j] = 0;
        for (int i = 0; i < m; i++)
            matrix[i][c] = 0;
    }
}