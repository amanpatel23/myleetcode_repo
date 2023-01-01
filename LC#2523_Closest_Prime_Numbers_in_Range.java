class Solution {
    public int[] closestPrimes(int left, int right) {
        
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        
        for (int p = 2; (long) p * p <= right; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= right; i += p) {
                    prime[i] = false;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }
        
        if (list.size() <= 1) return new int[]{-1, -1};
        int[] ans = new int[]{list.get(0), list.get(1)};
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < ans[1] - ans[0]) {
                ans[0] = list.get(i - 1);
                ans[1] = list.get(i);
            }
        }
        
        return ans;
    }
}