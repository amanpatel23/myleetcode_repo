class Solution {
    private int[] record;
    private final int p = 31, mod1 = (int) (1e9 + 7);
    private int[] dp;
    public int maxPalindromes(String s, int k) {

        int n = s.length();
        record = new int[n];
        Arrays.fill(record, -1);
        util(s, n, k);

        dp = new int[n];
        Arrays.fill(dp, -1);
        return getMax(0, n);
    }

    private int getMax(int i, int n) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int ans = getMax(i + 1, n);
        if (record[i] != -1) ans = Math.max(ans, 1 + getMax(i + record[i], n));
        return dp[i] = ans;
    }

    private void util(String s, int n, int k) {
        for (int ii = 0; ii < n; ii++) {
            long hashff = 0, hashss = 0, power = 1;
            for (int i = ii; i < n; i++) {
                int ascii = s.charAt(i) - 'a' + 1;
                hashff = (hashff + ((ascii * power) % mod1)) % mod1;
                hashss = (hashss * p) % mod1;
                hashss = (hashss + ascii) % mod1;
                power = (power * p) % mod1;

                if (hashff == hashss && (i - ii + 1) >= k) {
                    record[ii] = i - ii + 1;
                    break;
                }
            }
        }
    }
}