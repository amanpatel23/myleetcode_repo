class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        int n = recipes.length;
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        
        while (true) {
            
            boolean made = false;
            for (int i = 0; i < n; i++) {
                if (set.contains(recipes[i]))
                    continue;
                
                boolean contains_all = true;
                for (String ing: ingredients.get(i)) {
                    contains_all = contains_all && set.contains(ing);
                }
                
                if (contains_all) {
                    set.add(recipes[i]);
                    result.add(recipes[i]);
                    made = true;
                }
            }
            
            if (!made)
                break;
        }
        
        return result;
    }
}