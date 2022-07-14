class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    public int idealArrays(int n, int maxValue) {
        
        List<List<Integer>> factors = new ArrayList<>();
        for (int i = 0; i <= maxValue; i++) factors.add(new ArrayList<>());
        for (int i = 2; i <= maxValue; i++) {
            factors.get(i).add(1);
            for (int ii = 2; ii * ii <= i; ii++) {
                if ((i % ii) == 0) {
                    factors.get(i).add(ii);
                    int jj = i / ii;
                    if (jj != ii) factors.get(i).add(jj);
                }
            }
        }
        
        long[][] dp = new long[16][maxValue  + 1];
        for (int j = 1; j <= maxValue; j++) dp[1][j] = 1;
        for (int i = 2; i <= 15; i++) {
            for (int j = 1; j <= maxValue; j++) {
                for (int x : factors.get(j)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][x]) % mod;
                }
            }
        }
        
        Calc_nCr ncr = new Calc_nCr(n + 5, mod);
        long ans = 0;
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= maxValue; j++) {
                long curr = (dp[i][j] * ncr.nCr(n - 1, i - 1)) % mod;
                ans = (ans + curr) % mod;
            }
        }
        
        return (int) ans;
    }
    
    private static long pow(long a, long b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1L) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return result;
    }
    
    private static class Calc_nCr {
        private final long[] fact;
        private final long[] invfact;
        private final int p;

        Calc_nCr(int n, int prime) {
            fact = new long[n + 5];
            invfact = new long[n + 5];
            p = prime;

            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = (i * fact[i - 1]) % p;
            }

            invfact[n] = pow(fact[n], p - 2, p);
            for (int i = n - 1; i >= 0; i--) {
                invfact[i] = (invfact[i + 1] * (i + 1)) % p;
            }
        }

        private long nCr(int n, int r) {
            if (r > n || n < 0 || r < 0) return 0;
            return (((fact[n] * invfact[r]) % p) * invfact[n - r]) % p;
        }
    }
}