class Solution {
    
    private static int maxV = (int) (1e9);
    private static Map<Integer, Integer> rank;
    public int longestConsecutive(int[] nums) {
        
        for (int i = 0; i < nums.length; i++)
            nums[i] += maxV;
        
        rank = new HashMap<>();
        for (int num: nums)
            rank.put(num, -1);
        
        for (int num: nums) {
            if (rank.containsKey(num - 1)) {
                int p1 = findParent(num);
                int p2 = findParent(num - 1);
                if (p1 != p2)
                    union(p1, p2);
            }
        }
        
        //System.out.println(rank);
        int result = 0;
        for (Map.Entry<Integer, Integer> x: rank.entrySet()) {
            if (x.getValue() < 0)
                result = Math.max(result, Math.abs(x.getValue()));
        }
        
        return result;
    }
    
    private static int findParent(int num) {
        if (rank.get(num) < 0)
            return num;
        int p = findParent(rank.get(num));
        rank.put(num, p);
        return p;
    }
    
    private static void union(int _p1, int _p2) {
        int p1 = Math.min(_p1, _p2);
        int p2 = Math.max(_p1, _p2);
        rank.put(p1, rank.get(p1) + rank.get(p2));
        rank.put(p2, p1);
    }
}