class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int l = 0, r = (int) (1e7);
        while (r - l > 1) {
            
            int mid = l + ((r - l) / 2);
            if (check(mid, candies, k)) l = mid;
            else r = mid;
        }
        
        return (check(r, candies, k) ? r : l);
    }
    
    private static boolean check(int x, int[] candies, long k) {
        
        long cnt = 0;
        for (int candy : candies) cnt += (candy / x);
        return (cnt >= k);
    }
}