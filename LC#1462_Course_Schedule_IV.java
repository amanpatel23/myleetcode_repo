class Solution {
    
    private static List<List<Integer>> adjList;
    private static final int maxV = 100;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prereq, int[][] queries) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= maxV; i++) adjList.add(new ArrayList<>());
        for (int[] arr : prereq) adjList.get(arr[1]).add(arr[0]);
        
        List<Boolean> result = new ArrayList<>();
        for (int[] arr : queries) {
            boolean[] visited = new boolean[maxV + 1];
            result.add(dfs(arr[1], arr[0], visited));
        }
        
        return result;
    }
    
    private static boolean dfs(int curr_node, int target_node, boolean[] visited) {
        
        if (curr_node == target_node) return true;
        visited[curr_node] = true;
        for (int x : adjList.get(curr_node)) {
            if (!visited[x] && dfs(x, target_node, visited)) return true;
        }
        return false;
    }
}