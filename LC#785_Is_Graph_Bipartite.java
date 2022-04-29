class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] assignedColor = new int[n];
        Arrays.fill(assignedColor, -1);
        for (int i = 0; i < n; i++) {
            if (assignedColor[i] == -1 && !dfs(i, 0, assignedColor, graph))
                return false;
        }
        return true;
    }
    
    private static boolean dfs(int curr_node, int curr_color, int[] assignedColor, 
                              int[][] g) {
        if (assignedColor[curr_node] != -1)
            return assignedColor[curr_node] == curr_color;
        assignedColor[curr_node] = curr_color;
        for (int x : g[curr_node]) {
            if (!dfs(x, curr_color ^ 1, assignedColor, g)) 
                return false;
        }
        return true;
    }
}