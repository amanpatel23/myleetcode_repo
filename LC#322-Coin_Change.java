class Solution {
    
    final int MAX = (int) (1e9);
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] dpArr = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                if(i == 0 && j == 0 || j == 0)
                    dpArr[i][j] = 0;
                else if(i == 0)
                    dpArr[i][j] = MAX;
                else
                {
                    if(j < coins[i - 1])
                        dpArr[i][j] = dpArr[i - 1][j];
                    else
                        dpArr[i][j] = Math.min(1 + dpArr[i][j - coins[i - 1]], dpArr[i - 1][j]);
                }
            }
        }
        
        return (dpArr[n][amount] == MAX ? -1 : dpArr[n][amount]);
    }
}