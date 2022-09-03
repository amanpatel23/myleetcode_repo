class Solution {
    private static int ans = 0;
    public int maximumRows(int[][] mat, int cols) {

        int m = mat.length, n = mat[0].length;
        ans = 0;
        util(0, n, m, mat, cols, 0);
        return ans;
    }

    private static void util(int i, int n, int m, int[][] mat, int cols, int mask) {
        if (i >= n) {
            int cnt = 0;
            for (int bit = 0; bit < 15; bit++) {
                if (((mask >> bit) & 1) == 1) cnt++;
            }
            if (cnt == cols) ans = Math.max(ans, getAns(mask, mat, n, m));
            return;
        }

        util(i + 1, n, m, mat, cols, mask | (1 << i));
        util(i + 1, n, m, mat, cols, mask);
    }
    
    private static int getAns(int mask, int[][] mat, int n, int m) {
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (((mask >> j) & 1) == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}