class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            getNums(i, n, ans);
        }
        return ans;
    }
    
    private void getNums(int num, int n, List<Integer> list) {
        if (num > n) return;
        list.add(num);
        for (int i = 0; i < 10; i++) {
            getNums((num * 10) + i, n, list);
        }
    }
}