class Solution {
    
    private static final int p = 31, mod = (int) (1e9 + 7);
    private static long[] power_arr;
    private static int[] dp;
    public int deleteString(String s) {

        int n = s.length();
        long[] hash_arr = rolling_hash(s);
        System.out.println(Arrays.toString(hash_arr));
        
        dp = new int[n];
        Arrays.fill(dp, -1);
        return maxOp(0, n, hash_arr);
    }

    private static long[] rolling_hash(String str) {
        int n = str.length();
        long[] hash_arr = new long[n];
        power_arr = new long[n];
        long pow = 1;
        for (int i = 0; i < n; i++) {
            int ascii = str.charAt(i) - 'a' + 1;
            hash_arr[i] = (ascii * pow) % mod;
            power_arr[i] = pow;
            if (i > 0) hash_arr[i] = (hash_arr[i - 1] + hash_arr[i]) % mod;
            pow = (pow * p) % mod;
        }

        return hash_arr;
    }

    private static int maxOp(int i, int n, long[] hash_arr) {
        if (i >= n) return 0;
        
        if (dp[i] != -1) return dp[i];
        int ans = 1 + maxOp(n, n, hash_arr);
        for (int ii = 1; ; ii++) {
            if (i + ii + ii - 1 >= n) break;
            long hash1 = hash_arr[i + ii - 1];
            if (i > 0) hash1 = (hash1 - hash_arr[i - 1] + mod) % mod;
            long hash2 = hash_arr[i + ii + ii - 1];
            hash2 = (hash2 - hash_arr[i + ii - 1] + mod) % mod;
            hash1 = (hash1 * power_arr[ii]) % mod;
            
            if (hash1 == hash2) {
                ans = Math.max(ans, 1 + maxOp(i + ii, n, hash_arr));
            }
        }
        
        return dp[i] = ans;
    }
}