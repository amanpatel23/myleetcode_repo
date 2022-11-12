class Solution {
    private static List<List<Integer>> adjList;
    private static int[] record;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        int n = amount.length;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        record = new int[n];
        Arrays.fill(record, -1);

        dfs(bob, -1, 0, new Stack<>());

        int max = (int) (-1e9 + 200);
        int[] vis = new int[n];
        vis[0] = 1;
        Queue<int[]> qq = new LinkedList<>();
        qq.add(new int[]{0, 0, amount[0]});
        while (!qq.isEmpty()) {
            int size = qq.size();
            while (size-- > 0) {
                int[] front = qq.poll();
                int node = front[0], time = front[1], cost = front[2];
                if (adjList.get(node).size() == 1 && node != 0) {
                    max = Math.max(max, cost);
                }
                for (int xx : adjList.get(node)) {
                    if (vis[xx] == 1) continue;
                    vis[xx] = 1;
                    if (record[xx] != -1) {
                        if (time + 1 == record[xx]) cost += (amount[xx] / 2);
                        else if (time + 1 < record[xx]) cost += (amount[xx]);
                    } else cost += amount[xx];
                    qq.add(new int[]{xx, time + 1, cost});
                    cost = front[2];
                }
            }
        }
        
        return max;
    }

    private static void dfs(int curr, int par, int time, Stack<int[]> stack) {
        if (curr == 0) {
            while (!stack.empty()) {
                int[] top = stack.pop();
                record[top[0]] = top[1];
            }
            return;
        }

        stack.add(new int[]{curr, time});
        for (int x : adjList.get(curr)) {
            if (x == par) continue;
            dfs(x, curr, time + 1, stack);
        }
        if (!stack.isEmpty())
            stack.pop();
    }
}