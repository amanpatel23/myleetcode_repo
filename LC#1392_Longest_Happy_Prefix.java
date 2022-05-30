class Solution {
    private static final int p = 31, mod = (int) (1e9 + 7);
    public String longestPrefix(String s) {
        int n = s.length();
        int idx = -1;
        int i = 0, j = n - 1;
        long hash1 = 0, hash2 = 0;
        long prime = 1;
        while (i < n - 1) {
            int ascii1 = s.charAt(i) - 'a', ascii2 = s.charAt(j) - 'a';
            hash1 = (hash1 + (ascii1 * prime) % mod) % mod;
            hash2 = ((hash2 * p) + ascii2) % mod;
            if (hash1 == hash2) idx = i;
            prime = (prime * p) % mod;
            i++; j--;
        }
        return s.substring(0, idx + 1);
    }
}