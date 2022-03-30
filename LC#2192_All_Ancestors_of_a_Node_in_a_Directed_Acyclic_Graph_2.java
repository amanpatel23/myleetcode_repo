class Solution {
    
    private static List<List<Integer>> adjList;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) adjList.get(edge[1]).add(edge[0]);
        
        List<List<Integer>> result_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            List<Integer> list = new ArrayList<>();
            dfs(i, visited, list);
            Collections.sort(list);
            result_list.add(list);
        }
        
        return result_list;
    }
    
    private static void dfs(int curr, boolean[] visited, List<Integer> list) {
        
        visited[curr] = true;
        for (int x : adjList.get(curr)) {
            if (!visited[x]) { 
                list.add(x);
                dfs(x, visited, list);
            }
        }
    }
}