class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        
        int[] dp = new int[n + 1];
        
        int prev = 0;
        int result = 0;
        for (int i = (m - 1); i >= 0; i--) {
            for (int j = (n - 1); j >= 0; j--) {
                int temp = dp[j];
                if (matrix[i][j] == '0')
                    dp[j] = 0;
                else {
                    dp[j] = 1 + Math.min(Math.min(dp[j + 1], dp[j]), prev);
                }
                prev = temp;
                result = Math.max(result, dp[j]);
            }
        }
        
        return (result * result);
    }
}