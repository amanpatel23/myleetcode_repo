class Solution {
    
    val maxN = (1e5).toInt()
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        
        val prefixArr = Array(maxN + 5) { 0L }
        val breaks = Array(maxN + 5) { 0 }
        for (segment in segments) {
            val (st, end, color) = listOf(segment[0], segment[1], segment[2])
            prefixArr[st] += color.toLong()
            prefixArr[end] -= color.toLong()
            breaks[st] = 1; breaks[end] = 1
        }
        
        for (i in 1..maxN) {
            prefixArr[i] += prefixArr[i - 1]
        }
        val result = mutableListOf<List<Long>>()
        var (st, end) = listOf(0, 1)
        var prevColor = 0L
        var i = 1
        while (i <= maxN) {
            if (breaks[i] == 1) {
                if (prevColor != 0L) {
                    result.add(listOf(st.toLong(), end.toLong(), prevColor))
                }
                st = i; end = i + 1; prevColor = prefixArr[i]
            }else {
                end += 1
            }
            i++
        }
        
        return result
    }
}