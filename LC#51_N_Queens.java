class Solution {
    private static List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        solve(new ArrayList<>(), 0, n);
        return result;
    }
    
    private static void solve(List<Integer> list, int i, int n) {
        if (i == n) {
            result.add(designBoard(list, n));
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (canPlace(list, i - 1, n, j - 1, j , j + 1)) {
                list.add(j);
                solve(list, i + 1, n);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private static boolean canPlace(List<Integer> list, int i, int n,
                                    int left, int st, int right) {
        if (i < 0) return true;
        if (!((left >= 0 && list.get(i) == left) || list.get(i) == st || 
              (right < n && list.get(i) == right)))
            return canPlace(list, i - 1, n, left - 1, st, right + 1);
        return false;
    }
    
    private static List<String> designBoard(List<Integer> list, int n) {
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (list.get(i) == j) str.append('Q');
                else str.append('.');
            }
            result.add(str.toString());
        }
        return result;
    }
            
}