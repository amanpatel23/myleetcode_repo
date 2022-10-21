class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1) - list.get(i) <= k) return true;
            }
        }
        return false;
    }
}