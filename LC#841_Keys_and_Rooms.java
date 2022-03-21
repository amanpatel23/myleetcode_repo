class Solution {
    
    private static int n;
    private static boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        n = rooms.size();
        visited = new boolean[n];
        
        dfs(0, rooms);
        boolean result = true;
        for (int i = 0; i < n; i++) result = (result && visited[i]);
        return result;
    }
    
    private static void dfs(int curr, List<List<Integer>> rooms) {
        
        if (visited[curr]) return;
        
        visited[curr] = true;
        for (int x : rooms.get(curr))
            dfs(x, rooms);
    }
}