class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        
        val (m, n) = listOf(matrix.size, matrix[0].size)
        
        var (l, r) = listOf(0, m - 1)
        fun check1(i: Int): Boolean {
            return (matrix[i][0] <= target)
        }
        
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            if (check1(mid)) {
                l = mid
            }else {
                r = mid
            }
        }
        
        var row = -1
        if (target in matrix[l][0]..matrix[l][n - 1])
            row = l
        else if(target in matrix[r][0]..matrix[r][n - 1])
            row = r
        
        if (row == -1)
            return false
        
        l = 0; r = n - 1
        fun check2(i: Int): Boolean {
            return matrix[row][i] <= target
        }
        
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            if (check2(mid))
                l = mid
            else
                r = mid
        }
        
        var col = -1
        if (matrix[row][l] == target)
            col = l
        else if(matrix[row][r] == target)
            col = r
        
        if (col == -1)
            return false
        
        return true
    }
}