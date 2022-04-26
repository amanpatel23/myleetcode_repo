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
        
        int ans = 0;
        boolean[] inMST = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.offer(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            int[] curr = new int[]{-1, -1};
            while (true) {
                int[] top = pq.poll();
                if (inMST[top[0]]) continue;
                curr = top;
                break;
            }
            
            inMST[curr[0]] = true;
            ans += curr[1];
            for (int ii = 0; ii < n; ii++) {
                if (!inMST[ii]) pq.offer(new int[]{ii, adjMatrix[curr[0]][ii]});
            }
        }
        
        return ans;
    }
}