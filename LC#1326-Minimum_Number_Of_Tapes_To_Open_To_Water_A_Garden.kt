class Solution {
    
    val iMax = (1e9).toLong()
    fun minTaps(n: Int, ranges: IntArray): Int {

        val tapes = mutableListOf<Pair<Int, Int>>()
        for (i in 0..n) {
            tapes.add(Pair(maxOf(0, i - ranges[i]), minOf(n, i + ranges[i])))
        }

        tapes.sortBy { it.first }

        var count = 0
        val dp = LongArray(n + 5) { _ -> -1L }
        fun solve(i: Int, st: Int, finish: Int): Long {
            //System.out.println("$i $st $finish")
            //count++
            if (i > n)
                return (if (st == 0 && finish == n) 0 else iMax)
            
            if (dp[finish] != -1L)
                return dp[finish]
            
            if (tapes[i].first !in st..finish)
                return iMax
            
            val ans = minOf(solve(i + 1, st, finish), 
                         1 + solve(i + 1, st, maxOf(finish, tapes[i].second)))
            dp[finish] = ans
            return ans
        }
        
        val result = solve(0, 0, 0)
        //System.out.println(count)
        return (if (result >= iMax) -1 else result.toInt())
    }
}