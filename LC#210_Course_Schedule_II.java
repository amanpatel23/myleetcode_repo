class Solution {
    
    private static List<List<Integer>> adjList;
    public int[] findOrder(int n, int[][] prerequisites) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        int[] indegrees = new int[n];
        for (int[] prereq : prerequisites) {
            int a = prereq[0], b = prereq[1];
            adjList.get(b).add(a);
            indegrees[a]++;
        }
        
        // check for cycles in graph
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean[] temp_visited = new boolean[n];
            if (detectCycle(i, temp_visited, visited))
                return new int[]{};
        }
        
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                qq.offer(i);
            }
        }
        
        int idx = 0;
        int[] result = new int[n];
        while (!qq.isEmpty()) {
            
            int front = qq.poll();
            result[idx++] = front;
            for (int x : adjList.get(front)) {
                indegrees[x]--;
                if (indegrees[x] == 0) qq.offer(x);
            }
        }
        
        return result;
    }
    
    private static boolean detectCycle(int curr, boolean[] temp_visited, 
                                       boolean[] visited) {
        
        if (temp_visited[curr]) return true;
        if (visited[curr]) return false;
        
        temp_visited[curr] = true;
        visited[curr] = true;
        for (int x : adjList.get(curr)) {
            if (detectCycle(x, temp_visited, visited)) return true;
        }
        
        temp_visited[curr] = false;
        return false;
    }
}