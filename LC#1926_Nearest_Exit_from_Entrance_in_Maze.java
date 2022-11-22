class Solution {
    
    private final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int nearestExit(char[][] maze, int[] ent) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> qq = new LinkedList<>();
        qq.add(new int[]{ent[0], ent[1], 0});
        maze[ent[0]][ent[1]] = '+';
        boolean flag = false;
        while (!qq.isEmpty()) {
            int[] front = qq.poll();
            int r = front[0], c = front[1], cost = front[2];
            if (flag && (r == 0 || r == m - 1 || c == 0 || c == n - 1)) return cost;
            for (int[] dd : dir) {
                int rr = r + dd[0], cc = c + dd[1];
                if (rr < 0 || cc < 0 || rr == m || cc == n || 
                    maze[rr][cc] == '+') continue;
                maze[rr][cc] = '+';
                qq.add(new int[]{rr, cc, cost + 1});
            }
            flag = true;
        }
        return -1;
    }
}