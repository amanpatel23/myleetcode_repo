class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);
        list.sort(Comparator.comparingInt(x -> endTime[x]));
        
        int[] dp = new int[n];
        dp[0] = profit[list.get(0)];
        for (int i = 1; i < n; i++) {
            int st = startTime[list.get(i)];
            int cost = profit[list.get(i)];
            
            int idx = bs(list, endTime, i - 1, st);
            int temp = cost + ((idx == -1) ? 0 : dp[idx]);
            dp[i] = Math.max(temp, dp[i - 1]);
        }
        
        return dp[n - 1];
    }
    
    private int bs(List<Integer> list, int[] endTime, int ii, int x) {
        int l = 0, r = ii;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            int idx = list.get(mid);
            if (endTime[idx] <= x) l = mid;
            else r = mid;
        }
        int idx = list.get(r);
        if (endTime[idx] <= x) return r;
        idx = list.get(l);
        if (endTime[idx] <= x) return l;
        return -1;
    }
}