class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        
        val (m, n) = listOf(matrix.size, matrix[0].size)
        
        var (l, r) = listOf(0, (m * n) - 1)
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            if (matrix[mid / n][mid % n] <= target)
                l = mid
            else
                r = mid
        }
        
        if (matrix[l / n][l % n] == target)
            return true
        if (matrix[r / n][r % n] == target)
            return true
        
        return false
    }
}