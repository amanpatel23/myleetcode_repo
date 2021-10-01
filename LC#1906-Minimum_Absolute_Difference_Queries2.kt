class Solution {
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        
        val n = nums.size
        val indexes = mutableListOf<MutableList<Int>>()
        for (i in 0..100)
            indexes.add(mutableListOf())
            
        for (i in 0 until n) {
            indexes[nums[i]].add(i)
        }
        
        val q = queries.size
        val result = IntArray(q) { _ -> -1 }
        
        fun binarySearch(num: Int, l: Int, r: Int): Boolean {
            if (indexes[num].size == 0)
                return false
            
            var (low, high) = listOf(0, indexes[num].size - 1)
            while (high - low > 1) {
                val mid = (low + high) / 2
                if (indexes[num][mid] in l..r)
                    return true

                if (indexes[num][mid] < l)
                    low = mid
                else
                    high = mid
            }

            return (indexes[num][high] in l..r || indexes[num][low] in l..r)
        }
        
        for (i in 0 until q) {
            var (l, r) = listOf(queries[i][0], queries[i][1])
            
            val numList = mutableListOf<Int>()
            for (num in 1..100) {
                if (binarySearch(num, l, r))
                    numList.add(num)
            }
            
            var minAbsDiff = if (numList.size == 1) -1 else (1e9).toInt()
            for (i in 1 until numList.size)
                minAbsDiff = minOf(minAbsDiff, numList[i] - numList[i - 1])
                
            result[i] = minAbsDiff
        }
        
        return result
    }
}