class Solution {
    
    private static int[][] adjMatrix;
    private static final int iMax = (int) (1e9);
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                    Math.abs(points[i][1] - points[j][1]);
                adjMatrix[i][j] = dist;
                adjMatrix[j][i] = dist;
            }
        }
        
        return MST_Wt(n);
    }
    
    private static int MST_Wt(int n) {
        int[] keys = new int[n];
        Arrays.fill(keys, iMax);
        keys[0] = 0;
        boolean[] mst_included = new boolean[n];
        
        for (int i = 0; i < (n - 1); i++) {
            int curr = minKeyNode(n, keys, mst_included);
            mst_included[curr] = true;
            for (int ii = 0; ii < n; ii++) {
                if (mst_included[ii]) continue;
                keys[ii] = Math.min(keys[ii], adjMatrix[curr][ii]);
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) sum += keys[i];
        return sum;
    }
    
    private static int minKeyNode(int n, int[] keys, boolean[] mst_included) {
        int node = -1, wt = iMax;
        for (int i = 0; i < n; i++) {
            if (!mst_included[i] && (keys[i] < wt)) {
                node = i;
                wt = keys[i];
            }
        }
        return node;
    }
}