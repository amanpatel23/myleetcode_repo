class Solution {
    
    private static int n1, n2;
    public int findRadius(int[] houses, int[] heaters) {
        
        n1 = houses.length;
        n2 = heaters.length;
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int l = 0, r = (int) (1e9);
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (_check(houses, heaters, mid))
                r = mid;
            else
                l = mid;
        }
        
        int result = (_check(houses, heaters, l)) ? l : r;
        return result;
    }
    
    private static boolean _check(int[] houses, int[] heaters, int x) {
        
        int idx1 = 0;
        for (int idx2 = 0; idx2 < n2; idx2++) {
            int l = heaters[idx2] - x;
            int r = heaters[idx2] + x;
            while (idx1 < n1) {
                if (houses[idx1] >= l && houses[idx1] <= r) {
                    idx1++;
                    continue;
                }
                break;
            }
        }
        
        return (idx1 >= n1);
    }
}