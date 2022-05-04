class Solution {
    
    private static final int p1 = 211, p2 = 223, mod = (int) (1e9 + 7);
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int ans = 0;
        for (int w = 1; w <= n; w++) {
            Set<Pair<Long, Long>> set = new HashSet<>();
            int cnt = w;
            Long sum1 = 0L, sum2 = 0L;
            Long power1 = 1L, power2 = 1L;
            int divi = 0;
            for (int i = (n - 1); i >= 0; i--) {
                if (cnt-- > 0) {
                    if ((nums[i] % p) == 0) divi++;
                    sum1 = (sum1 * p1) % mod; sum2 = (sum2 * p2) % mod;
                    sum1 = (sum1 + nums[i]) % mod; sum2 = (sum2 + nums[i]) % mod;
                    power1 = (power1 * p1) % mod; power2 = (power2 * p2) % mod;
                    if (cnt == 0 && divi <= k) {
                        ans++;
                        set.add(new Pair(sum1, sum2));
                    }
                    continue;
                }
                
                if ((nums[i + w] % p) == 0) divi--;
                if ((nums[i] % p) == 0) divi++;
                
                sum1 = (sum1 * p1) % mod; 
                sum2 = (sum2 * p2) % mod;
                
                sum1 = (sum1 - ((nums[i + w] * power1) % mod) + mod) % mod;
                sum2 = (sum2 - ((nums[i + w] * power2) % mod) + mod) % mod;
                
                sum1 = (sum1 + nums[i]) % mod;
                sum2 = (sum2 + nums[i]) % mod;
                
                Pair<Long, Long> _pair = new Pair(sum1, sum2);
                if (divi <= k && !set.contains(_pair)) {
                    ans++;
                    set.add(_pair);
                }
            }
        }
        
        return ans;
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