class Solution {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        
        val n = rungs.size
        var (prev, curr) = listOf(0, 0)
        var result = 0
        for(i in 0 until n) {
            curr = rungs[i]
            result += ((curr - prev - 1) / dist)
            prev = curr
        }
        
        return result
    }
}