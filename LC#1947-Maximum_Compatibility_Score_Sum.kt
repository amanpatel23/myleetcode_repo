class Solution {
    fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
        
        val (m, n) = listOf(students.size, students[0].size)
        
        val dp = Array(8) { Array((1 shl 8) + 5) { -1 }}
        fun solve(i: Int, mask: Int): Int {
            if (i >= m)
                return 0
            
            if (dp[i][mask] != -1)
                return dp[i][mask]
            
            var ans = 0
            for (idx in 0 until m) {
                if (mask and (1 shl idx) == 0) {
                    ans = maxOf(ans, score(students[i], mentors[idx], n) + solve(i + 1, mask or (1 shl idx)))
                }
            }
            
            dp[i][mask] = ans
            return ans
        }
        
        val result = solve(0, 0)
        return result
    }
    
    fun score(sScore: IntArray, mScore: IntArray, n: Int): Int {
        var result = 0
        for (i in 0 until n) {
            if (sScore[i] == mScore[i])
                result++
        }
        return result
    }
}