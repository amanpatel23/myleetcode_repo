class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static List<List<Integer>> list = List.of(List.of(1, 2, 4), 
                                                        List.of(0, 2), 
                                                        List.of(1, 3), 
                                                        List.of(2), 
                                                        List.of(2, 3));
    public int countVowelPermutation(int n) {
        
        int[] dp = new int[5], temp = new int[5];
        Arrays.fill(dp, 1);
        int result = 5;
        for (int j = 2; j <= n; j++) {
            for (int i = 0; i < 5; i++)
                temp[i] = dp[i];
            result = 0;
            for (int i = 0; i < 5; i++) {
                dp[i] = 0;
                for (int idx : list.get(i))
                    dp[i] = (dp[i] + temp[idx]) % mod;
                result = (result + dp[i]) % mod;
            }
        }
        
        return result;
    }
}