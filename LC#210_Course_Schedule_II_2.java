class Solution {
    
    private static List<List<Integer>> adjList;
    public int[] findOrder(int n, int[][] prerequisites) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] prereq : prerequisites) adjList.get(prereq[1]).add(prereq[0]);
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean[] temp_visited = new boolean[n];
            if (dfs(i, visited, temp_visited, stack)) return new int[]{};
        }
        
        int[] result = new int[n];
        int idx = 0;
        while (!stack.isEmpty()) result[idx++] = stack.pop();
        return result;
    }
    
    private static boolean dfs(int curr, boolean[] visited, boolean[] temp_visited, 
                              Stack<Integer> stack) {
        
        if (temp_visited[curr]) return true;
        if (visited[curr]) return false;
        temp_visited[curr] = true;
        visited[curr] = true;
        for (int x : adjList.get(curr)) {
            if (dfs(x, visited, temp_visited, stack)) return true;
        }
        
        temp_visited[curr] = false;
        stack.add(curr);
        
        return false;
    }
}