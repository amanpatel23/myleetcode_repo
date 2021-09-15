class Solution {
    val mod = (1e9 + 7).toInt()
    fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
        val n = nextVisit.size
        val dp = Array(n) { 0L }
        for (i in 1 until n) {
            dp[i] = (2L + (2L * dp[i - 1]) - dp[nextVisit[i - 1]] + mod) % mod
        }
        
        return dp[n - 1].toInt()
    }  
}