class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums) {
            left.put(num, left.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (left.get(num) == 0) continue;
            left.put(num, left.get(num) - 1);
            if (record.getOrDefault(num - 1, 0) > 0) {
                record.put(num - 1, record.get(num - 1) - 1);
                record.put(num, record.getOrDefault(num, 0) + 1);
            } else if (left.getOrDefault(num + 1, 0) > 0 && 
                      left.getOrDefault(num + 2, 0) > 0) {
                left.put(num + 1, left.get(num + 1) - 1);
                left.put(num + 2, left.get(num + 2) - 1);
                record.put(num + 2, record.getOrDefault(num + 2, 0) + 1);
            } else
                return false;
        }
        return true;
    }
}