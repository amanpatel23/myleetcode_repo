class Solution {
    
    private static int n;
    private static List<List<Integer>> adjList;
    public int maximumDetonation(int[][] bombs) {
        
        n = bombs.length;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (check(i, j, bombs)) adjList.get(i).add(j);
            }
        }
        
        int result = 1;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> qq = new LinkedList<>();
            qq.offer(i);
            visited[i] = true;
            int cnt = 1;
            while (!qq.isEmpty()) {
                int front = qq.poll();
                for (int x : adjList.get(front)) {
                    if (!visited[x]) {
                        qq.offer(x);
                        visited[x] = true;
                        cnt++;
                    }
                }
            }
            
            result = Math.max(result, cnt);
        }
        
        return result;
    }
    
    private static boolean check(int i, int j, int[][] bombs) {
        long x1 = bombs[i][0], y1 = bombs[i][1];
        long x2 = bombs[j][0], y2 = bombs[j][1];
        long r = bombs[i][2];
        return (((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))) <= (r * r);
    }
}