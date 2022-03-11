class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = (i == 0) ? j : i;
                    continue;
                }
                
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        StringBuilder result = new StringBuilder();
        int i = n1, j = n2;
        while (!(i == 0 && j == 0)) {
            if (i == 0) {
                result.append(str2.charAt(j - 1));
                j--;
                continue;
            }
            if (j == 0) {
                result.append(str1.charAt(i - 1));
                i--;
                continue;
            }
            
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            }else {
                if (dp[i - 1][j] == (dp[i][j] - 1)) {
                    result.append(str1.charAt(i - 1));
                    i--;
                }else {
                    result.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }
        
        return result.reverse().toString();
    }
}s