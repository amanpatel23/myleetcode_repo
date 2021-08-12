class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        
        val m = board.size
        val n = board[0].size
        val len = word.length
        
        val visited = Array(m) { Array(n) { 0 }}
        fun dfs(i: Int, j: Int, idx: Int): Boolean {
            
            if (idx >= len)
                return true
            
            if (i < 0 || i >= m || j < 0 || j >= n)    
                return false
            
            if (visited[i][j] == 1 || board[i][j] != word[idx])
                return false
            
            visited[i][j] = 1
            
            val result = dfs(i - 1, j, idx + 1) ||
                   dfs(i + 1, j, idx + 1) ||
                   dfs(i, j + 1, idx + 1) ||
                   dfs(i, j - 1, idx + 1)
                   
            visited[i][j] = 0
            return result
        }
        
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(i, j, 0))
                    return true
            }
        }
        
        return false
    }
}