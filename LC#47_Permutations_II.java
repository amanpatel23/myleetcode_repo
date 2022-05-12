class Solution {
    
    private static List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        ans = new ArrayList<>();
        
        solve(0, new ArrayList<>(), map, nums.length);
        return ans;
    }
    
    private static void solve(int i, List<Integer> list, Map<Integer, Integer> map, 
                              int n) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int num = -10; num <= 10; num++) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                solve(i + 1, list, map, n);
                list.remove(list.size() - 1);
                map.put(num, map.get(num) + 1);
            }
        }
    }
}