class Solution {
    public int maximumRobots(int[] ct, int[] rt, long budget) {
        
        int n = ct.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(x -> -x));
        long sum = 0;
        int ans = 0;
        int i = 0, j = 0;
        while (j < n) {
            sum += rt[j];
            put(map, ct[j]);
            
            long curr = map.firstKey() + (sum * (j - i + 1));
            while (curr > budget) {
                sum -= rt[i];
                remove(map, ct[i]);
                curr = (map.size() == 0 ? 0 : map.firstKey()) + (sum * (j - i + 1));
                i++;
            }
            
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        
        return ans;
    }
    
    private static void put(TreeMap<Integer, Integer> map, int k) {
        map.put(k, map.getOrDefault(k, 0) + 1);
    }
    
    private static void remove(TreeMap<Integer, Integer> map, int k) {
        map.put(k, map.get(k) - 1);
        if (map.get(k) == 0) map.remove(k);
    }
}