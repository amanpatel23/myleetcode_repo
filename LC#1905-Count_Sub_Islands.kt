class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        
        val (m, n) = listOf(grid1.size, grid1[0].size)
        
        var result = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid2[i][j] == 1) {
                    var flag = true
                    
                    fun dfs(i: Int, j: Int) {
                        if (i >= m || i < 0 || j >= n || j < 0 || grid2[i][j] == 0)
                            return
                        
                        grid2[i][j] = 0
                        if (grid1[i][j] == 0)
                            flag = false
                        
                        dfs(i - 1, j)
                        dfs(i, j + 1)
                        dfs(i + 1, j)
                        dfs(i, j - 1)
                    }
                    
                    dfs(i, j)
                    if (flag)
                        result++
                }
            }
        }
        
        return result
    }
}