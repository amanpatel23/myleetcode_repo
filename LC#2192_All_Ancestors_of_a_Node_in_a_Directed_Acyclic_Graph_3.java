class Solution {
    
    private static List<List<Integer>> adjList, result_list;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        adjList = new ArrayList<>();
        result_list = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            adjList.add(new ArrayList<>());
            result_list.add(new ArrayList<>());
        }
        for (int[] edge : edges) adjList.get(edge[0]).add(edge[1]);
        
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, visited);
        }
        return result_list;
    }
    
    private static void dfs(int curr, int ancestor, boolean[] visited) {
        
        visited[curr] = true;
        for (int x : adjList.get(curr)) {
            if (!visited[x]) {
                result_list.get(x).add(ancestor);
                dfs(x, ancestor, visited);
            }
        }
    }
}