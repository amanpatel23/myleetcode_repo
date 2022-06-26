class Solution {
    
    private static final long lMax = (long) (1e15), lMin = (long) (-1e15);
    private static List<List<Integer>> adjList;
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] arr : edges) {
            int a = arr[0], b = arr[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        List<Set<Integer>> children_list = new ArrayList<>();
        for (int i = 0; i < n; i++) children_list.add(new HashSet<>());
        int[] subtree_xor = new int[n];
        getChildren(-1, 0, children_list, subtree_xor, nums);
        
        int len = edges.length;
        int ans = (int) (2e9);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == j) continue;
                int a1 = edges[i][0], b1 = edges[i][1];
                int a2 = edges[j][0], b2 = edges[j][1];
                int l1, l2;
                if (children_list.get(a1).contains(b1)) l1 = b1;
                else l1 = a1;
                if (children_list.get(a2).contains(b2)) l2 = b2;
                else l2 = a2;
                
                int one, two, three;
                if (children_list.get(l1).contains(l2)) {
                    one = subtree_xor[0] ^ subtree_xor[l1];
                    two = subtree_xor[l1] ^ subtree_xor[l2];
                    three = subtree_xor[l2];
                } else if (children_list.get(l2).contains(l1)) {
                    one = subtree_xor[0] ^ subtree_xor[l2];
                    two = subtree_xor[l2] ^ subtree_xor[l1];
                    three = subtree_xor[l1];
                } else {
                    one = subtree_xor[0] ^ subtree_xor[l1] ^ subtree_xor[l2];
                    two = subtree_xor[l1];
                    three = subtree_xor[l2];
                }
                
                int max = (int) getMax(one, two, three);
                int min = (int) getMin(one, two, three);
                ans = Math.min(ans, max - min);
            }
        }
        
        return ans;
    }
    
    private static Set<Integer> getChildren(int p, int curr, 
                                            List<Set<Integer>> children_list, 
                                            int[] subtree_xor, int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int x : adjList.get(curr)) {
            if (x == p) continue;
            set.addAll(getChildren(curr, x, children_list, subtree_xor, nums));
        }
        
        children_list.get(curr).addAll(set);
        set.add(curr);
        int xor = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) xor ^= nums[(int) it.next()];
        subtree_xor[curr] = xor;
        return set;
    }
    
    private static long getMin(long... args) {
        long min = lMax;
        for (long arg : args)
            min = Math.min(min, arg);
        return min;
    }

    private static long getMax(long... args) {
        long max = lMin;
        for (long arg : args)
            max = Math.max(max, arg);
        return max;
    }
    
}