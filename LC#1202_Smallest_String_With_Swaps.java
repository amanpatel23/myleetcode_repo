class Solution {
    
    private static List<List<Integer>> adjList;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (List<Integer> x : pairs) {
            adjList.get(x.get(0)).add(x.get(1));
            adjList.get(x.get(1)).add(x.get(0));
        }
        
        Character[] result = new Character[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            List<Integer> indexes = new ArrayList<>();
            dfs(i, indexes, visited);
            Collections.sort(indexes);
            List<Integer> sorted = indexes.stream().
                sorted(Comparator.comparingInt(x -> s.charAt(x))).toList();
            for (int ii = 0; ii < indexes.size(); ii++) {
                result[indexes.get(ii)] = s.charAt(sorted.get(ii));
            }
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) str.append(result[i]);
        return str.toString();
    }
    
    private static void dfs(int curr, List<Integer> list, boolean[] visited) {
        
        list.add(curr);
        visited[curr] = true;
        for (int x : adjList.get(curr)) {
            if (!visited[x])
                dfs(x, list, visited);
        }
    }
}