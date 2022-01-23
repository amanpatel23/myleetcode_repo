class Solution {
    
    private static final int iMin = (int) (-1e9);
    private static int n;
    public int maximumGood(int[][] matrix) {
        
        n = matrix.length;
        int result = 0;
        for (int i = 0; i < (1 << n); i++) {
            result = Math.max(result, util(matrix, i));
        }
        
        return result;
    }
    
    private static int util(int[][] matrix, int mask) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                count++;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 2)
                        continue;
                    if (matrix[i][j] != ((mask >> j) & 1))
                        return iMin;
                }
            }
        }
        
        return count;
    }
}