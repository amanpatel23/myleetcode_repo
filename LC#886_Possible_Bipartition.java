class Solution {
    
    private static List<List<Integer>> adjList;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : dislikes) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        
        int[] assignedColor = new int[n + 1];
        Arrays.fill(assignedColor, -1);
        for (int i = 1; i <= n; i++) {
            if (assignedColor[i] != -1) continue;
            if (!isBipartite(i, 0, assignedColor)) return false;
        }
        return true;
    }
    
    private static boolean isBipartite(int curr_node, int curr_color, 
                                       int[] assignedColor) {
        
        assignedColor[curr_node] = curr_color;
        for (int x : adjList.get(curr_node)) {
            if (assignedColor[x] == -1) 
                isBipartite(x, curr_color ^ 1, assignedColor);
            else if (assignedColor[x] == curr_color) return false;
        }
        
        return true;
    }
}