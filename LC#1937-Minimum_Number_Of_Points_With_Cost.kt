class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        
        val m = points.size
        val n = points[0].size
        val dp = Array(m) { Array(n) { -1L }}
        for(j in 0 until n) {
            dp[0][j] = points[0][j].toLong()
        }
        
        for(i in 1 until m) {
            
            val left = Array(n){ 0L }
            val right = Array(n){ 0L }
            
            left[0] = dp[i - 1][0]
            for(k in 1 until n){
                left[k] = maxOf(left[k - 1], dp[i - 1][k] + k.toLong())
            }
            
            right[n - 1] = dp[i - 1][n - 1] - (n.toLong() - 1L)
            for(k in (n - 2) downTo 0) {
                right[k] = maxOf(right[k + 1], dp[i - 1][k] - k.toLong())
            }
            
            for(j in 0 until n) {
                dp[i][j] = maxOf(points[i][j] - j + left[j], points[i][j] + j + right[j])
            }
        }
        
        return dp[m - 1].max()!!
    }
}