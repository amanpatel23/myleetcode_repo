class Solution {
    
    private static final int inf = (int) (1e6);
    public int minSwap(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long[] dp1 = new long[n], dp2 = new long[n];
        Arrays.fill(dp2, 1);
        for (int i = 1; i < n; i++) {
            // fill dp1 cell
            // If I didn't swapped the previous indexs
            long temp1 = ((nums1[i] > nums1[i - 1]) && (nums2[i] > nums2[i - 1])) ? 
                            dp1[i - 1] : inf;
            // If I did swapped the previous indexes
            long temp2 = ((nums1[i] > nums2[i - 1]) && (nums2[i] > nums1[i - 1])) ?
                            dp2[i - 1] : inf;
            dp1[i] = Math.min(temp1, temp2);
            
            // fill dp2 cell
            // If I didn't swapped the previous indexes
            temp1 = ((nums2[i] > nums1[i - 1]) && (nums1[i] > nums2[i - 1])) ? 
                    dp1[i - 1] : inf;
            // If I did swapped the previous indexes
            temp2 = ((nums2[i] > nums2[i - 1]) && (nums1[i] > nums1[i - 1])) ? 
                    dp2[i - 1] : inf;
            dp2[i] += Math.min(temp1, temp2);
            
        }
        
        return (int) Math.min(dp1[n - 1], dp2[n - 1]);
    }
}