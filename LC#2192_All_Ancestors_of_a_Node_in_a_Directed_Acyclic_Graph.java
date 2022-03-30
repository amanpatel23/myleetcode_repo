class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        List<Set<Integer>> indegrees = new ArrayList<>();
        for (int i = 0; i < n; i++) indegrees.add(new HashSet<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            indegrees.get(edge[1]).add(edge[0]);
        }
        
        int[][] result_arr = new int[n][n];
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegrees.get(i).size() == 0) qq.offer(i);
        while (!qq.isEmpty()) {
            int front = qq.poll();
            for (int x : adjList.get(front)) {
                for (int i = 0; i < n; i++) {
                    if (result_arr[front][i] == 1) result_arr[x][i] = 1;
                }
                result_arr[x][front] = 1;
                indegrees.get(x).remove(front);
                if (indegrees.get(x).size() == 0) qq.offer(x);
            }
        }
        
        List<List<Integer>> result_list = new ArrayList<>();
        for (int i = 0; i < n; i++) result_list.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result_arr[i][j] == 1) 
                    result_list.get(i).add(j);
            }
        }
        
        return result_list;
    }
}