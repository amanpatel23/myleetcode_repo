class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') continue;
            if (i == 0 || (i - 1 - dp[i - 1]) < 0 || 
                s.charAt(i - 1 - dp[i - 1]) == ')') continue;
            dp[i] = i - (i - 1 - dp[i - 1]) + 1;
            if (i - 1 - dp[i - 1] > 0)
                dp[i] += dp[i - 1 - dp[i - 1] - 1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}