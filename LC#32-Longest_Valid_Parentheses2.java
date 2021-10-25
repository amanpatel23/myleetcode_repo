class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;
                }else if ((i - dp[i - 1]) > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 
                            ((i - dp[i - 1] > 1) ? dp[i - dp[i - 1] - 2] :0) + 2;
                }
            }
            
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}