class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Set<Integer>> adjList = createGraph(k, rowConditions);
        List<Integer> topoSort_rows = topoSort(k, adjList);
        adjList = createGraph(k, colConditions);
        List<Integer> topoSort_cols = topoSort(k, adjList);

        if (topoSort_rows.size() < k || topoSort_cols.size() < k) return new int[][]{};
        int[][] ans = new int[k][k];
        int[] col_pos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            int node = topoSort_cols.get(i);
            col_pos[node] = i;
        }
        for (int i = 0; i < k; i++) {
            int node = topoSort_rows.get(i);
            ans[i][col_pos[node]] = node;
        }
        return ans;
    }

    private static List<Set<Integer>> createGraph(int k, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        return adjList;
    }

    private static List<Integer> topoSort(int k, List<Set<Integer>> adjList) {

        int[] inorder = new int[k + 5];
        for (int i = 1; i <= k; i++) {
            for (int node : adjList.get(i)) {
                inorder[node]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> qq = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inorder[i] == 0) {
                qq.add(i);
            }
        }

        while (!qq.isEmpty()) {
            int front = qq.poll();
            ans.add(front);
            for (int node : adjList.get(front)) {
                if (--inorder[node] == 0) qq.add(node);
            }
        }

        return ans;
    }
}