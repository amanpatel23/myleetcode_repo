class Solution {
    
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, 
                                                   {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static int m, n;
    public void gameOfLife(int[][] board) {
        
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = util(board, i, j);
                if (board[i][j] == 0 && lives == 3) board[i][j] = 2;
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) board[i][j] = 3;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == 3) board[i][j] = 0;
            }
        }
    }
    
    private static int util(int[][] board, int i, int j) {
        
        int cnt = 0;
        for (int[] arr : dir) {
            int i_new = i + arr[0], j_new = j + arr[1];
            if (!(i_new >= 0 && j_new >= 0 && i_new < m && j_new < n)) continue;
            if (board[i_new][j_new] == 1 || board[i_new][j_new] == 3) cnt++;
        }
        return cnt;
    }
}