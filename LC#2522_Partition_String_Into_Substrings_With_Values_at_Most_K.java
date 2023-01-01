class Solution {
    private int dd;
    private int k;
    private int[][] dp;
    public int minimumPartition(String s, int _k) {
        k = _k;
        dd = noOfDigits(k);
        
        dp = new int[s.length()][11];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        int ans = helper(s, 1, 1);
        if (ans == (int) (1e6)) return -1;
        return ans;
    }
    
    private int helper(String str, int i, int len) {
        if (i == str.length()) {
            if (len < dd) return 1;
            boolean temp = check(str, i);
            if (temp) return 1;
            else return (int) (1e6);
        }
        
        if (dp[i][len] != -1) return dp[i][len];
        
        if (len == dd) {
            int ans = (int) (1e6);
            boolean temp = check(str, i);
            if (temp) return dp[i][len] = Math.min((int) (1e6), 1 + helper(str, i + 1, 1));
            else return dp[i][len] = (int) (1e6);
        } else {
            int ans = Math.min(helper(str, i + 1, len + 1), 1 + helper(str, i + 1, 1));
            return dp[i][len] = Math.min((int) (1e6), ans);
        }
    }
    
    private boolean check(String str, int i) {
        long sum = 0, pow = 1;
        for (int ii = i - 1; ii >= i - dd; ii--) {
            int curr = str.charAt(ii) - '0';
            curr *= pow;
            sum += curr;
            pow *= 10;
        }
        return sum <= k;
    }
    
    private int noOfDigits(int num) {
        int ans = 0;
        while (num > 0) {
            num /= 10;
            ans++;
        }
        return ans;
    }
}