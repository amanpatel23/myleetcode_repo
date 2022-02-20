class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int gcd1 = gcd(nums[i], k);
            int gcd2 = k / gcd1;
            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                if (x.getKey() % gcd2 == 0)
                    result += x.getValue();
            }
            
            map.put(gcd1, map.getOrDefault(gcd1, 0) + 1);
        }
        
        return result;
    }
    
    private static int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }
}