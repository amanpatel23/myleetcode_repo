class Solution {
    
    private static final int maxV = (int) (1e4);
    private static final int iMax = (int) (1e9);
    public int maxArea(int[] height) {
        
        int n = height.length;
        int[] left_most = new int[maxV + 5], right_most = new int[maxV + 5];
        Arrays.fill(left_most, iMax);
        for (int i = 0; i < n; i++) {
            int h = height[i];
            right_most[h] = i + 1;
            left_most[h] = Math.min(i + 1, left_most[h]);
        }
        
        int min = iMax, max = 0;
        int ans = 0;
        for (int i = maxV; i > 0; i--) {
            min = Math.min(min, left_most[i]);
            max = Math.max(max, right_most[i]);
            if (max > 0) ans = Math.max(ans, (max - min) * i);
        }
        
        return ans;
    }
}