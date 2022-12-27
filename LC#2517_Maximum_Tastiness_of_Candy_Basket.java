class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0, r = price[n - 1];
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(price, mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (check(price, r, k)) {
            return r;
        }
        return l;
    }
    
    private boolean check(int[] price, int x, int k) {
        int prev = price[0];
        int i = 1;
        int cnt = 1;
        while (cnt < k && i < price.length) {
            if (price[i] - prev >= x) {
                prev = price[i];
                cnt++;
            }
            i++;
        }
        return cnt >= k;
    }
}