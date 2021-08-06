class Solution {
    fun numIslands(_grid: Array<CharArray>): Int {
        val grid = _grid
        val m = grid.size
        val n = grid[0].size
        
        var result = 0
        
        fun util(qq: ArrayDeque<Pair<Int, Int>>) {
            while (qq.isNotEmpty()) {
                val curr = qq.poll()
                val i = curr.first
                val j = curr.second
                grid[i][j] = '0'
                if (i - 1 >= 0 && grid[i - 1][j] == '1')
                    qq.push(Pair(i - 1, j))
                if (i + 1 < m && grid[i + 1][j] == '1')
                    qq.push(Pair(i + 1, j))
                if (j + 1 < n && grid[i][j + 1] == '1')
                    qq.push(Pair(i, j + 1))
                if (j - 1 >= 0 && grid[i][j - 1] == '1')
                    qq.push(Pair(i, j - 1))
            }
        }
        
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    val qq = ArrayDeque<Pair<Int, Int>>()
                    qq.push(Pair(i, j))
                    util(qq)
                    result++
                }
            }
        }
        
        return result
        
    }
}