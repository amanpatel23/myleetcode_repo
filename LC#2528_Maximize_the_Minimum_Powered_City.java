class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int ll = Math.max(0, i - r);
            int rr = Math.min(n - 1, i + r);
            
            prefixSum[ll] += stations[i];
            prefixSum[rr + 1] -= stations[i];
        }
        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        
        long lo = 0, hi = (long) (1e15);
        while (hi - lo > 1) {
            long mid = lo + ((hi - lo) / 2);
            if (check(prefixSum, mid, n, r, k)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        long ans = check(prefixSum, hi, n, r, k) ? hi : lo;
        return ans;
    }
    
    private boolean check(long[] prefixSum, long x, int n, int r, int k) {
        
        long[] temp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (i > 0) temp[i] += temp[i - 1];
            long curr = prefixSum[i] + temp[i];
            if (curr >= x) continue;
            long diff = x - curr;
            if (diff > k) return false;
            k -= diff;
            
            int rr = Math.min(n - 1, i + 2 * r);
            temp[i] += diff;
            temp[rr + 1] -= diff;
        }
        
        return true;
    }
}