class Solution {
    
    private static final long[] best = new long[1005];
    private static final long lMax = (long) (1e15);
    private static int max_len = 0;
    private static final long[] dp = new long[1005];
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        Arrays.fill(best, lMax);
        for (int[] tire : tires) {
            int f = tire[0], r = tire[1];
            long curr_time = f, total_time = f;
            int curr_len = 1;
            for (int lap = 1; lap <= numLaps && curr_time < (changeTime + f); lap++) {
                max_len = Math.max(max_len, curr_len);
                best[lap] = Math.min(best[lap], total_time);
                curr_time *= r;
                total_time += curr_time;
                curr_len++;
            }
        }
        
        Arrays.fill(dp, -1);
        int result = (int) minTime(numLaps, changeTime);
        return result;
    }
    
    private static long minTime(int n, int changeTime) {
        
        if (n == 0)
            return -changeTime;
        
        if (dp[n] != -1)
            return dp[n];
        
        long ans = lMax;
        for (int i = 1; i <= Math.min(n, max_len); i++)
            ans = Math.min(ans, best[i] + changeTime + minTime(n - i, changeTime));
        
        return (dp[n] = ans);
    }
}