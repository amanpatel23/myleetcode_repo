class Solution {
    public boolean checkValid(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n + 1];
            Arrays.fill(check, false);
            for (int j = 0; j < n; j++) {
                check[matrix[i][j]] = true;
            }
            boolean result = true;
            for (int k = 1; k <= n; k++)
                result = result && check[k];
            if (!result)
                return false;
        }
        
        for (int j = 0; j < n; j++) {
            boolean[] check = new boolean[n + 1];
            Arrays.fill(check, false);
            for (int i = 0; i < n; i++) {
                check[matrix[i][j]] = true;
            }
            boolean result = true;
            for (int k = 1; k <= n; k++)
                result = result && check[k];
            if (!result)
                return false;
        }
        
        return true;
    }
}