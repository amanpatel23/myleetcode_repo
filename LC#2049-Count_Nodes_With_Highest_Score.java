class Solution {
    
    static ArrayList<ArrayList<Integer>> tree;
    static ArrayList<Long> scores;
    static int n;
    public int countHighestScoreNodes(int[] parents) {
        
        tree = new ArrayList<>();
        scores = new ArrayList<>();
        
        n = parents.length;
    
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<Integer>());
        
        for (int i = 1; i < n; i++)
            tree.get(parents[i]).add(i);
        
        //System.out.println(tree);
        dfs(0);
        
        Collections.sort(scores, Collections.reverseOrder());
        //System.out.println(scores);
        long match = scores.get(0);
        
        int result = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == match)
                result++;
        }
        
        return result;
        
    }
    
    static int dfs(int node) {
        
        int _size = tree.get(node).size();
        int sum_l = (_size > 0) ? (1 + dfs(tree.get(node).get(0))) : 0;
        int sum_r = (_size > 1) ? (1 + dfs(tree.get(node).get(1))) : 0;
        
        long result = Math.max(1, sum_l) * 1L * Math.max(1, sum_r) * Math.max(1, n - 1 - sum_l - sum_r);
        //System.out.println(node + " " + sum_l + " " + sum_r + " " + result);
        scores.add(result);
        
        return (sum_l + sum_r);
    }
}