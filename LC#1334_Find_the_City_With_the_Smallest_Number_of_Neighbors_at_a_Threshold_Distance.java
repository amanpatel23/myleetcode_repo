class Solution {
    
    private static final int iMax = (int) (1e9);
    public int findTheCity(int n, int[][] edges, int dTh) {
        
        int[][] dist = new int[n][n];
        for (int[] arr : dist) Arrays.fill(arr, iMax);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] edge : edges) { 
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int ans = -1;
        int cnt = iMax;
        for (int i = 0; i < n; i++) {
            int curr_cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= dTh) curr_cnt++;
            }
            
            if (curr_cnt <= cnt) {
                cnt = curr_cnt;
                ans = i;
            }
        }
        
        return ans;
    }
}