class Solution {
    
    private static int[][][] dp;
    public int countSpecialNumbers(int n) {
        int[] pre = new int[]{0, 9, 81, 648, 4536, 27216, 136080, 544320, 1632960, 3265920, 3265920};
        String str = n + "";
        int len = str.length();
        int ans = 0;
        for (int i = 1; i < len; i++) ans += pre[i];
        dp = new int[len][2][(1 << 10) + 5];
        for (int[][] rr : dp) {
            for (int[] r : rr) {
                Arrays.fill(r, -1);
            }
        }
        ans += util(0, 0, 0, len, str);
        return ans;
    }
    
    private static int util(int i, int mask, int freedom, int n, String str) {
        if (i >= n) return 1;
        if (dp[i][freedom][mask] != -1) return dp[i][freedom][mask];
        int ans = 0;
        int d = str.charAt(i) - '0';
        for (int ii = 0; ii < 10; ii++) {
            if (((mask >> ii) & 1) == 1) continue;
            if (mask == 0 && ii == 0) continue;
            if (freedom == 1) ans += util(i + 1, mask | (1 << ii), 1, n, str);
            else {
                if (ii < d) ans += util(i + 1, mask | (1 << ii), 1, n, str);
                if (ii == d) ans += util(i + 1, mask | (1 << ii), 0, n, str);
            }
        }
        return dp[i][freedom][mask] = ans;
    }
}