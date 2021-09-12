class Solution {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        
        val n = rectangles.size
        
        val pairFreq = mutableMapOf<Pair<Int, Int>, Int>()
        for (rect in rectangles) {
            val (w, h) = listOf(rect[0], rect[1])
            val gcd = gcd(w, h)
            val pair = Pair(w / gcd, h / gcd)
            pairFreq.putIfAbsent(pair, 0)
            pairFreq[pair] = pairFreq[pair]!! + 1
        }
        
        var result = 0L
        for ((_, v) in pairFreq) {
            result += ((v * 1L * (v - 1)) / 2L)
        }
        
        return result
    }
    
    fun gcd(a: Int, b: Int): Int {
        if (b == 0)
            return a
        return gcd(b, a % b)
    }
}