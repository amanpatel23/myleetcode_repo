class Solution {
    public int maxLength(List<String> arr) {
        return solve(0, arr, 0);
    }
    
    private int solve(int i, List<String> arr, int mask) {
        if (i == arr.size()) return noOfSetBits(mask);
        int ans = solve(i + 1, arr, mask);
        int curr = mask;
        for (char c : arr.get(i).toCharArray()) {
            int pos = c - 'a';
            if (((curr >> pos) & 1) == 1) return ans;
            curr |= (1 << pos);
        }
        return Math.max(ans, solve(i + 1, arr, curr));
    }
    
    private int noOfSetBits(int x) {
        int cnt = 0;
        while (x != 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }
}