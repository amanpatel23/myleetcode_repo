class Solution {
    
    private static final int iMax = (int) (1e9), iMin = (int) (-1e9);
    public boolean isPrintable(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] extreme_points = new int[61][4];
        for (int i = 1; i <= 60; i++) 
            extreme_points[i] = new int[]{iMax, iMax, iMin, iMin};
        Set<Integer> color_set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = grid[i][j];
                color_set.add(color);
                extreme_points[color][0] = Math.min(extreme_points[color][0], i);
                extreme_points[color][1] = Math.min(extreme_points[color][1], j);
                extreme_points[color][2] = Math.max(extreme_points[color][2], i);
                extreme_points[color][3] = Math.max(extreme_points[color][3], j);
            }
        }
        
        while (color_set.size() > 0) {
            Iterator<Integer> it = color_set.iterator();
            boolean flag = false;
            int color = -1;
            while (it.hasNext()) {
                color = it.next();
                if (can_remove(color, grid, extreme_points[color])) {
                    remove(grid, extreme_points[color]);
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                color_set.remove(color);
                continue;
            }
            
            return false;
        }
        
        return true;
    }
    
    private static boolean can_remove(int color, int[][] grid, int[] points) {
        
        for (int i = points[0]; i <= points[2]; i++) {
            for (int j = points[1]; j <= points[3]; j++) {
                if (grid[i][j] != 0 && grid[i][j] != color) return false;
            }
        }
        return true;
    }
    
    private static void remove(int[][] grid, int[] points) {
        
        for (int i = points[0]; i <= points[2]; i++) {
            for (int j = points[1]; j <= points[3]; j++) {
                grid[i][j] = 0;
            }
        }
    }
}