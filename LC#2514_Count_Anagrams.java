class Solution {
    
    private final int mod = (int) (1e9 + 7);
    private long pow_with_mod(long a, long b, int mod) {
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

    class Calc_nCr {
        public final long[] fact;
        public final long[] invfact;
        private final int p;

        Calc_nCr(int n, int prime) {
            fact = new long[n + 5];
            invfact = new long[n + 5];
            p = prime;

            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = (i * fact[i - 1]) % p;
            }

            invfact[n] = pow_with_mod(fact[n], p - 2, p);
            for (int i = n - 1; i >= 0; i--) {
                invfact[i] = (invfact[i + 1] * (i + 1)) % p;
            }
        }

        private long nCr(int n, int r) {
            if (r > n || n < 0 || r < 0) return 0;
            return (((fact[n] * invfact[r]) % p) * invfact[n - r]) % p;
        }
    }
    
    public int countAnagrams(String s) {
        
        Calc_nCr nCr = new Calc_nCr(s.length(), mod);
        String[] arr = s.split(" ");
        long ans = 1;
        for (String str : arr) {
            int[] freq = new int[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            long curr = nCr.fact[str.length()];
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 1) {
                    curr = (curr * nCr.invfact[freq[i]]) % mod;
                }
            }
            
            ans = (ans * curr) % mod;
        }
        
        return (int) ans;
    }
}