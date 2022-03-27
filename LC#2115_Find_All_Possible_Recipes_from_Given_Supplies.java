class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        int n = recipes.length;
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String recp = recipes[i];
            if (!indegrees.containsKey(recp)) indegrees.put(recp, 0);
            for (String ing : ingredients.get(i)) {
                if (!adjList.containsKey(ing)) adjList.put(ing, new ArrayList<>());
                adjList.get(ing).add(recp);
                indegrees.put(recp, indegrees.get(recp) + 1);
            }
        }
        
        List<String> result = new ArrayList<>();
        Queue<String> qq = new LinkedList<>();
        for (String supp : supplies) qq.offer(supp);
        while (!qq.isEmpty()) {
            String front = qq.poll();
            if (adjList.containsKey(front)) {
                for (String recp : adjList.get(front)) {
                    indegrees.put(recp, indegrees.get(recp) - 1);
                    if (indegrees.get(recp) == 0) {
                        result.add(recp);
                        qq.add(recp);
                    }
                }
            }
        }
        
        return result;
    }
}