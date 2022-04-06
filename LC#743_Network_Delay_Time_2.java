class Solution {
    
    private static final int iMax = (int) (1e9 + 100);
    public int networkDelayTime(int[][] times, int n, int src) {
        
        // Bellman Ford
        int[] timeTaken = new int[n + 1];
        Arrays.fill(timeTaken, iMax);
        timeTaken[src] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] arr : times) {
                if (timeTaken[arr[1]] > timeTaken[arr[0]] + arr[2]) 
                    timeTaken[arr[1]] = timeTaken[arr[0]] + arr[2];
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) ans = Math.max(ans, timeTaken[i]);
        return (ans == iMax ? -1 : ans);
    }
}