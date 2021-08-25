class Solution {
    fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
        
        val (m, n) = listOf(mat.size, mat[0].size)
        
        var count = 0
        val maxRow = 70
        val maxRowSum = 4900
        
        val dp = Array(maxRow + 1) { Array(maxRowSum + 5) { -1 }}
        fun minAbsDiff(i: Int, sum: Int): Int {
            count++
            if (i == m)
                return Math.abs(sum - target)
            
            if (dp[i][sum] != -1)
                return dp[i][sum]
            
            var ans = (1e9).toInt()
            for (num in mat[i]) {
                ans = minOf(ans, minAbsDiff(i + 1, sum + num))
            }
            
            dp[i][sum] = ans
            return ans
        }
        
        val result = minAbsDiff(0, 0)
        //System.out.println(count)
        return result
    }
}