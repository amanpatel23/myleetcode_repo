class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length;
        Arrays.sort(costs, Comparator.comparing(o -> o[0] - o[1]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < (n / 2)) ans += costs[i][0];
            else ans += costs[i][1];
        }
        
        return ans;
    }
}