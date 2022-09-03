class Solution {
    
    private static List<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        
        list = new ArrayList<>();
        for (int i = 1; i < 10; i++) solve(1, n, k, i);
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i] = list.get(i);
        return ans;
    }
    
    private static void solve(int i, int n, int k, int num) {
        if (i >= n) {
            list.add(num);
            return;
        }
        
        int prev = num % 10;
        if (prev - k >= 0) solve(i + 1, n, k, (num * 10) + (prev - k));
        if (k != 0 && prev + k < 10) solve(i + 1, n, k, (num * 10) + (prev + k));
    }
}