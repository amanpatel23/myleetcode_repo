class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int n = stations.length;
        
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        
        boolean[] used = new boolean[n];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            int idx = -1;
            for (int j = 0; j < n; j++) {
                if (stations[j][0] > dp[i - 1])
                    break;
                if (used[j])
                    continue;
                if (max < stations[j][1]) {
                    idx = j;
                    max = stations[j][1];
                }
            }
            
            dp[i] = dp[i - 1] + max;
            if (idx != -1)
                used[idx] = true;
        }
        
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target)
                return i;
        }
        
        return -1;
    }
}