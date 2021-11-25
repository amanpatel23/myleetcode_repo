class Solution {
    
    private static int n1, n2;
    private static List<Pair> result;
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        
        n1 = a.length;
        n2 = b.length;
        result = new ArrayList<>();
        solve(a, b, 0, 0);
        
        int len = result.size();
        int[][] resultArr = new int[len][2];
        for (int i = 0; i < len; i++) {
            int x = result.get(i).x;
            int y = result.get(i).y;
            resultArr[i][0] = x;
            resultArr[i][1] = y;
        }
        
        return resultArr;
    }
    
    private static void solve(int[][] a, int[][] b, int i, int j) {
        
        if (i >= n1 || j >= n2)
            return;
        
        if (a[i][0] > b[j][1])
            solve(a, b, i, j + 1);
        else if (b[j][0] > a[i][1])
            solve(a, b, i + 1, j);
        else {
            Pair temp = new Pair(Math.max(a[i][0], b[j][0]), 
                                 Math.min(a[i][1], b[j][1]));
            result.add(temp);
            if (a[i][1] <= b[j][1])
                solve(a, b, i + 1, j);
            else
                solve(a, b, i, j + 1);
        }
        
        return;
    }
    
    private static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}