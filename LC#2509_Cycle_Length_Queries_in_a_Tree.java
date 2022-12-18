class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            
            Map<Integer, Integer> mapff = new HashMap<>();
            int levff = 0;
            while (max > 0) {
                mapff.put(max, levff);
                if (max == min) {
                    ans[i] = levff + 1;
                    break;
                }
                max /= 2;
                levff++;
            }
            
            Map<Integer, Integer> mapss = new HashMap<>();
            int levss = 0;
            while (min > 0) {
                mapss.put(min, levss);
                if (mapff.containsKey(min)) {
                    ans[i] = 1 + mapff.get(min) + mapss.get(min);
                    break;
                }
                min /= 2;
                levss++;
            }
        }
        
        return ans;
    }
}