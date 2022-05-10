class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << 9); i++) {
            if (setBits(i) == k && sum(i) == n) {
                List<Integer> temp = new ArrayList<>();
                for (int bit = 0; bit < 9; bit++) {
                    if (((i >> bit) & 1) == 1) temp.add(bit + 1);
                }
                ans.add(temp);
            }
        }
        
        return ans;
    }
    
    private static int setBits(int num) {
        int cnt = 0;
        while (num != 0) {
            num = num & (num - 1);
            cnt++;
        }
        return cnt;
    }
    
    private static int sum(int num) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (((num >> i) & 1) == 1) sum += (i + 1);
        }
        return sum;
    }
}