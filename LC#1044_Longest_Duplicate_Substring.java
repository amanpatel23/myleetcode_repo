class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static final int p1 = 37, p2 = 97;
    private static String s;
    private static int n; 
    private static long[] mul_inv1, mul_inv2, prefix_hash1, prefix_hash2;
    private static int result_l, result_r;
    public String longestDupSubstring(String _s) {
        
        s = _s;
        n = s.length();
        
        mul_inv1 = new long[n + 5];
        mul_inv2 = new long[n + 5];
        prefix_hash1 = new long[n + 5];
        prefix_hash2 = new long[n + 5];
        
        mul_inv1[0] = 1;
        mul_inv2[0] = 1;
        long curr1 = p1, curr2 = p2;
        for (int i = 1; i <= n; i++) {
            mul_inv1[i] = pow(curr1, mod - 2, mod);
            curr1 = (curr1 * p1) % mod;
            
            mul_inv2[i] = pow(curr2, mod - 2, mod);
            curr2 = (curr2 * p2) % mod;
        }
        
        prefix_hash1[0] = s.charAt(0) - 'a' + 1;
        prefix_hash2[0] = s.charAt(0) - 'a' + 1;
        curr1 = p1;
        curr2 = p2;
        for (int i = 1; i < n; i++) {
            prefix_hash1[i] = (prefix_hash1[i - 1] + 
                            ((s.charAt(i) - 'a' + 1) * curr1) % mod) % mod;
            curr1 = (curr1 * p1) % mod;
            
            prefix_hash2[i] = (prefix_hash2[i - 1] + 
                            ((s.charAt(i) - 'a' + 1) * curr2) % mod) % mod;
            curr2 = (curr2 * p2) % mod;
        }
        
        result_l = -1;
        result_r = -1;
        int l = 1, r = n - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(mid))
                l = mid;
            else
                r = mid;
        }
        
        check(l);
        check(r);
        
        if (result_l == -1)
            return "";
        return s.substring(result_l, result_r + 1);
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
    
    private static boolean check(int x) {
        
        Set<Pair<Long, Long>> set = new HashSet<>();
        for (int i = 0, j = x - 1; j < n; i++, j++) {
            long temp1 = (prefix_hash1[j] - (i == 0 ? 0 : prefix_hash1[i - 1]) + mod)
                        % mod;
            temp1 = (temp1 * mul_inv1[i]) % mod;
            
            long temp2 = (prefix_hash2[j] - (i == 0 ? 0 : prefix_hash2[i - 1]) + mod)
                        % mod;
            temp2 = (temp2 * mul_inv2[i]) % mod;
            
            if (set.contains(new Pair(temp1, temp2))) {
                result_l = i;
                result_r = j;
                return true;
            }
            set.add(new Pair(temp1, temp2));
        }
        
        return false;
    }
    
    private static class Pair<U, V> {

        private final U first;
        private final V second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        private Pair(U ff, V ss) {
            this.first = ff;
            this.second = ss;
        }
    }
}