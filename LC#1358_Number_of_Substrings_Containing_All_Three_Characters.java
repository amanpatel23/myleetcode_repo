class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] latest_ocuu = new int[]{-1, -1, -1};
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            latest_ocuu[ascii] = i;
            int min_idx = Math.min(latest_ocuu[0], 
                                   Math.min(latest_ocuu[1], latest_ocuu[2]));
            ans += (min_idx + 1);
        }
        
        return ans;
    }
}