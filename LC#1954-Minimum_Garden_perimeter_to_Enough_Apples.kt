class Solution {
    fun minimumPerimeter(neededApples: Long): Long {
        
        var (i, prev) = listOf(1L, 0L)
        var result = 1L
        while (true) {
            prev = prev + (12 * i * i)
            if (prev >= neededApples) {
                result = 8 * i
                break
            }
            
            i++
        }
        
        return result
    }
}