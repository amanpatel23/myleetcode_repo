class Solution {
    public String getSmallestString(int n, int k) {
        
        StringBuilder result = new StringBuilder();
        int prev = 0;
        for (int i = 1; i < n; i++) {
            for (int idx = 1; idx <= 26; idx++) {
                if (prev + idx + ((n - i) * 26) >= k) {
                    result.append((char) ('a' + idx - 1));
                    prev += idx;
                    break;
                }
            }
        }
        
        int left = Math.min(k - prev, 26);
        result.append((char) ('a' + left - 1));
        return result.toString();
    }
}