class Solution {
    
    private static long[] prefix_hash1, prefix_hash2;
    private static long[] modulo_mul_inv;
    private static final int p = 113, mod = (int) (1e9 + 7);
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        prefix_hash1 = new long[n1];
        prefix_hash2 = new long[n2];
        modulo_mul_inv = new long[Math.max(n1, n2)];
        
        long prime = 1;
        for (int i = 0; i < n1; i++) {
            prefix_hash1[i] = (prime * nums1[i]) % mod;
            if (i > 0) prefix_hash1[i] = (prefix_hash1[i] + prefix_hash1[i - 1]) % mod;
            prime = (prime * p) % mod;
        }
        prime = 1;
        for (int i = 0; i < n2; i++) {
            prefix_hash2[i] = (prime * nums2[i]) % mod;
            if (i > 0) prefix_hash2[i] = (prefix_hash2[i] + prefix_hash2[i - 1]) % mod;
            prime = (prime * p) % mod;
        }
        
        prime = 1;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            modulo_mul_inv[i] = pow(prime, mod - 2, mod);
            prime = (prime * p) % mod;
        }
        
        int l = 0, r = Math.min(n1, n2);
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(mid, n1, n2))
                l = mid;
            else
                r = mid;
        }
        return check(r, n1, n2) ? r : l;
    }
    
    private static boolean check(int x, int n1, int n2) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i + x <= n1; i++) {
            long val = prefix_hash1[i + x - 1];
            if (i > 0) val = (val - prefix_hash1[i - 1] + mod) % mod;
            val = (val * modulo_mul_inv[i]) % mod;
            set.add(val);
        }
        for (int i = 0; i + x <= n2; i++) {
            long val = prefix_hash2[i + x - 1];
            if (i > 0) val = (val - prefix_hash2[i - 1] + mod) % mod;
            val = (val * modulo_mul_inv[i]) % mod;
            if (set.contains(val)) return true;
        }
        return false;
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
}