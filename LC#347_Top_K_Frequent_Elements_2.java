class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) bucket.add(new ArrayList<>());
        for (int key : map.keySet()) bucket.get(map.get(key)).add(key);
        
        int cnt = k;
        int[] result = new int[k];
        for (int i = nums.length; i > 0; i--) {
            for (int x : bucket.get(i)) {
                result[--cnt] = x;
                if (cnt == 0) return result;
            }
        }
        return result;
    }
}