class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += util(i, i, s, n);
            ans += util(i, i + 1, s, n);
        }
        return ans;
    }
    
    private static int util(int ff, int ss, String s, int n) {
        int cnt = 0;
        while (ff >= 0 && ss < n && s.charAt(ff--) == s.charAt(ss++)) cnt++;
        return cnt;
    }
}