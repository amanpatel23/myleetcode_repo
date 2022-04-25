class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int ans = 0;
        for (int i = 0; i <= 205; i++) {
            for (int j = 0; j <= 205; j++) {
                int[] p1 = new int[]{i, j};
                for (int[] arr : circles) {
                    int[] p2 = new int[]{arr[0], arr[1]};
                    if (check(p1, p2, arr[2])) {
                        ans++;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
    
    private static boolean check(int[] p1, int[] p2, int r) {
        long lhs = ((p2[0] - p1[0]) * 1L * (p2[0] - p1[0])) + ((p2[1] - p1[1]) * 1L * (p2[1] - p1[1]));
        return lhs <= (r * 1L * r);
    }
}