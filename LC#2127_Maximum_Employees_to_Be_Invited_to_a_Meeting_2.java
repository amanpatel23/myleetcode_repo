class Solution {
    
    private static int maxCycle;
    public int maximumInvitations(int[] f) {
        
        int n = f.length;
        List<List<Integer>> rev_graph = new ArrayList<>();
        for (int i = 0; i < n; i++) rev_graph.add(new ArrayList<>());
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            rev_graph.get(f[i]).add(i);
            indegree[f[i]]++;
        }
        
        int[] arm_length = new int[n];
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) qq.offer(i);
        while (!qq.isEmpty()) {
            int front = qq.poll();
            int frnd = f[front];
            arm_length[frnd] = Math.max(arm_length[frnd], 1 + arm_length[front]);
            if (--indegree[frnd] == 0) qq.offer(frnd);
        }
        
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (f[f[i]] == i && (i < f[i])) {
                ans += (arm_length[i] + arm_length[f[i]] + 2);
            }
        }
        
        maxCycle = 0;
        boolean[] visited = new boolean[n], rec_stack = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                detectCycle(i, parent, visited, rec_stack, f);
            }
        }
        
        return Math.max(ans, maxCycle);
    }
    
    private static void detectCycle(int curr, int[] parent, boolean[] visited, 
                                  boolean[] rec_stack, int[] f) {
        
        visited[curr] = true;
        rec_stack[curr] = true;
        
        if (!visited[f[curr]]) {
            parent[f[curr]] = curr;
            detectCycle(f[curr], parent, visited, rec_stack, f);
        }else if (rec_stack[f[curr]]) {
            int vertex = curr, cnt = 1;
            while (vertex != f[curr]) {
                cnt++;
                vertex = parent[vertex];
            }
            maxCycle = Math.max(maxCycle, cnt);
        }
        
        rec_stack[curr] = false;
    }
}