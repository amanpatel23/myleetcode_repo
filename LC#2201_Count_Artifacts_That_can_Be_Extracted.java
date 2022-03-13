class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        int[][] grid = new int[n][n];
        for (int[] row : grid)
            Arrays.fill(row, -1);

        int[] area_covered = new int[(n * n) + 5];
        int next = 1;
        for (int[] x : artifacts) {
            int cnt = 0;
            for (int i = x[0]; i <= x[2]; i++) {
                for (int j = x[1]; j <= x[3]; j++) {
                    grid[i][j] = next;
                    cnt++;
                }
            }
            area_covered[next] = cnt;
            next++;
        }
        
        int result = 0;
        for (int[] x : dig) {
            int r = x[0], c = x[1];
            int num = grid[r][c];
            //System.out.println(r + " " + c + " " + num);
            if (num == -1)
                continue;
            area_covered[num] -= 1;
            if (area_covered[num] == 0)
                result++;
            grid[r][c] = -1;
        }
        
        return result;
    }
}