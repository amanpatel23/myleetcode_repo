class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            List<Integer> taken = new ArrayList<>();
            boolean[] visited = new boolean[n];
            taken.add(i);
            visited[i] = true;
            boolean global_flag = true;
            while (global_flag) {
                global_flag = false;
                for (int j = 0; j < n; j++) {
                    if (visited[j]) continue;
                    long x1 = bombs[j][0], y1 = bombs[j][1];
                    for (int idx : taken) {
                        long x2 = bombs[idx][0], y2 = bombs[idx][1];
                        long dist = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
                        long r = bombs[idx][2];
                        r *= r;
                        if (dist <= r) {
                            taken.add(j);
                            visited[j] = true;
                            global_flag = true;
                            break;
                        }
                    }
                }
            }
            
            ans = Math.max(ans, taken.size());
        }
        
        return ans;
    }
}