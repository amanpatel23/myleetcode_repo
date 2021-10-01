class Solution {
    
    val iMax = (1e9).toInt()
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        
        val n = nums.size
        val prefix = Array(n + 1) { IntArray(101) { _ -> 0 } }
        for (i in 0 until n) {
            for (j in 1..100) {
                prefix[i + 1][j] = prefix[i][j]
            }
            prefix[i + 1][nums[i]]++
        }
        
        val q = queries.size
        val result = IntArray(q) { _ -> -1 }
        var idx = 0
        queries.forEach {
            val (l, r) = listOf(it[0], it[1] + 1)
            val numList = mutableListOf<Int>()
            for (j in 1..100) {
                if (prefix[r][j] - prefix[l][j] > 0)
                    numList.add(j)
            }
            
            var minAbsDiff = if (numList.size == 1) -1 else iMax
            for (i in 1 until numList.size) {
                minAbsDiff = minOf(minAbsDiff, numList[i] - numList[i - 1])
            }
            
            result[idx] = minAbsDiff
            idx++
        }
        
        return result
    }
}