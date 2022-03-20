class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        Set<Integer> incoming_edges = new HashSet<>();
        for (List<Integer> edge : edges) incoming_edges.add(edge.get(1));
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!incoming_edges.contains(i)) result.add(i);
        }
        
        return result;
    }
}