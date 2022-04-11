class Solution {
    
    private static int maxCycle;
    public int maximumInvitations(int[] f) {
        
        int n = f.length;
        List<List<Integer>> rev_graph = new ArrayList<>();
        for (int i = 0; i < n; i++) rev_graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            rev_graph.get(f[i]).add(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (f[f[i]] == i && (i < f[i])) {
                int l = dfs(i, rev_graph, f[i]);
                int r = dfs(f[i], rev_graph, i);
                ans += (l + r);
            }
        }
        //System.out.println(ans);
        
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
    
    private static int dfs(int curr, List<List<Integer>> g, int ignore) {
        
        int ans = 0;
        for (int x : g.get(curr)) {
            if (x != ignore) ans = Math.max(ans, dfs(x, g, ignore));
        }
        return 1 + ans;
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