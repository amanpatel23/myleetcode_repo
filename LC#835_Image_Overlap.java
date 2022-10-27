class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int ii = 0; ii < n; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        int curr = 0;
                        for (int r1 = i, r2 = ii; r1 < n && r2 < n; r1++, r2++) {
                            for (int c1 = j, c2 = jj; c1 < n && c2 < n; c1++, c2++) {
                                if (img1[r1][c1] == 1 && img2[r2][c2] == 1) curr++;
                            }
                        }
                        ans = Math.max(ans, curr);
                    }
                }
            }
        }
        return ans;
    }
}