class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int[] order = new int[n];
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            order[edge[0]]++;
            order[edge[1]]++;
        }
        
        Queue<Integer> qq = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (order[i] == 1) {
                qq.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (n == 1)
            result.add(0);
        while (!qq.isEmpty()) {
            
            int _size = qq.size();
            result.clear();
            while (_size-- > 0) {
                int top = qq.poll();
                result.add(top);
                for (int x: adjList.get(top)) {
                    order[x]--;
                    if (order[x] == 1)
                        qq.add(x);
                }
            }
    
            _size = qq.size();
        }
        
        return result;
    }
}