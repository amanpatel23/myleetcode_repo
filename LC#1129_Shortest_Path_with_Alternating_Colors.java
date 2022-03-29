class Solution {
    
    private static final int iMax = (int) (1e9);
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        // 0 -> red, 1 -> blue
        for (int[] edge : redEdges) adjList.get(edge[0]).add(new int[]{edge[1], 0});
        for (int[] edge : blueEdges) adjList.get(edge[0]).add(new int[]{edge[1], 1});
        
        Queue<int[]> qq = new LinkedList<>();
        boolean[][] visited = new boolean[n][3];
        int[] result = new int[n];
        Arrays.fill(result, iMax);
        qq.offer(new int[]{0, 2, 0});
        while (!qq.isEmpty()) {
            
            int[] front = qq.poll();
            result[front[0]] = Math.min(result[front[0]], front[2]);
            visited[front[0]][front[1]] = true;
            for (int[] edge : adjList.get(front[0])) {
                if (edge[1] != front[1] && !visited[edge[0]][edge[1]]) {
                    qq.offer(new int[]{edge[0], edge[1], front[2] + 1});
                }
            }
        }
        
        for (int i = 0; i < n; i++) if (result[i] == iMax) result[i] = -1;
        return result;
    }
}