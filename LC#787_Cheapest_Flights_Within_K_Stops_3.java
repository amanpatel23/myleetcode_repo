class Solution {
    
    private static final int iMax = (int) (1e9);
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] min_cost = new int[n];
        Arrays.fill(min_cost, iMax);
        min_cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = min_cost.clone();
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                if (min_cost[from] == iMax) continue;
                temp[to] = Math.min(temp[to], min_cost[from] + cost);
            }
            min_cost = temp;
        }
        
        return (min_cost[dst] == iMax ? -1 : min_cost[dst]);
    }
}