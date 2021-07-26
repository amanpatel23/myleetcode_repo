const val inf = (1e15).toLong()
class Solution {
    
    val dp = Array(10005) { -1L }
    var count = 0
    fun coinChange(coins: IntArray, amount: Int): Int {
        
        val result = minCoins(coins, amount, 0)
        println(count)
        return if (result == inf) -1 else result.toInt()
    }
    
    fun minCoins(coins: IntArray, amount: Int, sum: Int): Long {
        count++
        if (sum == amount)
            return 0L
        
        if (dp[sum] != -1L)
            return dp[sum]
        
        var result = inf
        for (coin in coins) {
            if (sum + 1L + coin > 1L + amount)
                continue
            val ans = 1L + minCoins(coins, amount, sum + coin)
            result = minOf(result, ans)
        }
        
        dp[sum] = result
        return result
    }
}