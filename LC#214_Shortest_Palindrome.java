class Solution {
    
    private static final int p = 31, mod = (int) (1e9 + 7);
    public String shortestPalindrome(String s) {
        
        int n = s.length();
        long hash1 = 0, hash2 = 0, power = 1;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            int ascii = s.charAt(i) - 'a' + 1;
            hash1 = ((hash1 * p) + ascii) % mod;
            hash2 = (hash2 + (ascii * power)) % mod;
            if (hash1 == hash2) idx = i;
            power = (power * p) % mod;
        }
        
        return new StringBuilder().append(s.substring(idx + 1, n)).reverse().append(s).
            toString();
    }
}