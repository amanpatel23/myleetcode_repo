class Solution {
    
    val iMax = (1e9).toInt()
    val iMin = (-1e9).toInt()
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        
        val n = nums.size
        
        val dp = Array(205) { Array(205) { -1 }}
        fun solve(i: Int, k: Int): Int {
        
            if (i >= n)
                return 0
            if (k < 0)
                return iMax

            if (dp[i][k] != -1)
                return dp[i][k]
            
            var ans = iMax; var max = nums[i]; var sum = 0
            for (j in i until n) {
                max = maxOf(max, nums[j])
                sum += nums[j]
                val wasted = (max * (j - i + 1)) - sum
                ans = minOf(ans, wasted + solve(j + 1, k - 1))
            }
            
            dp[i][k] = ans
            return ans
        }
        
        val result = solve(0, k)
        return result
    }
}