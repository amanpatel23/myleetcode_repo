class Solution {
    
    private static final int mod = (int) (1e9 + 7);
    private static Map<Character, Integer> ref = 
        Map.of('a', 0, 'e', 1, 'i', 2, 'o', 3, 'u', 4);
    private static Map<Character, List<Character>> list = Map.of('a', List.of('e'), 
                                                 'e', List.of('a', 'i'),
                                                 'i', List.of('a', 'e', 'o', 'u'),
                                                 'o', List.of('i', 'u'),
                                                 'u', List.of('a'));
    private static int[][] dp = new int[5][(int) (2e4) + 5];
    public int countVowelPermutation(int n) {
        
        for (int i = 0; i < 5; i++)
            Arrays.fill(dp[i], -1);
        
        int result = 0;
        for (char c : ref.keySet())
            result = (result + solve(1, c, n)) % mod;
        
        return result;
    }
    
    private static int solve(int i, char prev, int n) {
        
        if (i == n)
            return 1;
        
        if (dp[ref.get(prev)][i] != -1)
            return dp[ref.get(prev)][i];
        
        int ans = 0;
        for (char c : list.get(prev))
            ans = (ans + solve(i + 1, c, n)) % mod;
        
        return dp[ref.get(prev)][i] = ans;
    }
}