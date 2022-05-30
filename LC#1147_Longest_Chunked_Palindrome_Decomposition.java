class Solution {
    private static final int p = 31, mod = (int) (1e9 + 7);
    public int longestDecomposition(String text) {
        int n = text.length();
        long hash1 = 0, hash2 = 0;
        long prime = 1;
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < n) {
            int ascii1 = text.charAt(i) - 'a', ascii2 = text.charAt(j) - 'a';
            hash1 = (hash1 + (ascii1 * prime) % mod) % mod;
            hash2 = (((hash2 * p) % mod) + ascii2) % mod;
            prime = (prime * p) % mod;
            if (hash1 == hash2) {
                ans++;
                hash1 = 0; hash2 = 0;
                prime = 1;
            }
            i++; j--;
        }
        
        return ans;
    }
}