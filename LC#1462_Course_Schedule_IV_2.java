class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prereq, int[][] queries) {
        
        boolean[][] canReach = new boolean[n][n];
        for (int[] arr : prereq) canReach[arr[0]][arr[1]] = true;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    canReach[i][j] = canReach[i][j] || (canReach[i][k] && canReach[k][j]);
                }
            }
        }
        
        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) result.add(canReach[q[0]][q[1]]);
        return result;
    }
}