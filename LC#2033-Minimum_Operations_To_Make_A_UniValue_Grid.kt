import kotlin.math.abs
class Solution {
    
    fun gcd(a: Int, b: Int): Int {
        if (b == 0)
            return a
        return gcd(b, a % b)
    }
    
    fun minOperations(grid: Array<IntArray>, x: Int): Int {

        val (m, n) = listOf(grid.size, grid[0].size)
        val nums = mutableListOf<Int>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                nums.add(grid[i][j])
            }
        }

        var gcd = 0
        val len = nums.size
        for (i in 0 until len) {
            val diff = abs(nums[0] - nums[i])
            gcd = gcd(gcd, diff)
        }
        
        if (gcd % x != 0) {
            return -1
        }
        
        nums.sort()
        var result: Int
        fun opt(median: Int): Int {
            var count = 0
            for (num in nums) {
                count += (abs(median - num) / x)
            }
            
            return count
        }
        if (len and 1 == 1) {
            val medainIdx = len / 2
            result = opt(nums[medainIdx])
        }else {
            val medainIdx = len / 2
            result = minOf(opt(nums[medainIdx]), opt(nums[medainIdx - 1]))
        }
        
        return result
    }
}