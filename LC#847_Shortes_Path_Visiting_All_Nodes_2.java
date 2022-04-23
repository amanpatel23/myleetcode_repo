class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n = graph.length;
        boolean[][] visited = new boolean[n][(1 << n)];
        Queue<int[]> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            qq.offer(new int[]{i, (1 << i)});
            visited[i][1 << i] = true;
        }
        int ans = 0;
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                int[] front = qq.poll();
                if (front[1] == ((1 << n) - 1)) return ans;
                for (int x : graph[front[0]]) {
                    if (visited[x][front[1] | (1 << x)]) continue;
                    visited[x][front[1] | (1 << x)] = true;
                    qq.offer(new int[]{x, front[1] | (1 << x)});
                }
            }
            ans++;
        }
        
        return -1;
    }
}