class Solution {
    
    private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        fillMatrix(0, 0, 0, 1, matrix, n);
        return matrix;
    }
    
    private static boolean fillMatrix(int i, int j, int curr,
                                      int num, int[][] matrix, int n) {
        
        if (i < 0 || i >= n || j < 0 || j >= n || matrix[i][j] > 0) return false;
        matrix[i][j] = num;
        if (num == (n * n)) return true;
        int next = (curr + 1) % 4;
        return fillMatrix(i + dir[curr][0], j + dir[curr][1], curr, num + 1, matrix, n) 
            || fillMatrix(i + dir[next][0], j + dir[next][1], next, num + 1, matrix, n);
    }
}