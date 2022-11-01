class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int j = 0; j < n; j++) {
            int ii = 0, jj = j;
            while (true) {
                if (ii == m) {
                    ans[j] = jj;
                    break;
                }
                int temp = jj + grid[ii][jj];
                if (temp < 0 || temp == n || grid[ii][jj] != grid[ii][temp]) break;
                jj = temp;
                ii++;
            }
        }
        return ans;
    }
}