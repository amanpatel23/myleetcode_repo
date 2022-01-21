class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long l = 0, r = 0;
        for (int batt : batteries)
            r += batt;
        r /= n;
        
        while (r - l > 1) {
            long mid = l + ((r - l) / 2);
            if (check(n, batteries, mid))
                l = mid;
            else
                r = mid;
        }

        return (check(n, batteries, r) ? r : l);
    }

    private static boolean check(int n, int[] batteries, long x) {
        
        long temp = 0;
        for (int batt : batteries)
            temp += Math.min(batt, x);
        return (temp >= (n * x));
    }
}