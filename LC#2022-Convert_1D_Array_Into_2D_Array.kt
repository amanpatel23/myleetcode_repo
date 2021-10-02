class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {

        val originalLen = original.size
        val resultSize = m * 1L * n

        val result = Array(m) { IntArray(n) }
        if (resultSize != originalLen.toLong())
            return emptyArray()

        var (r, c) = listOf(0, 0)
        for (i in 0 until originalLen) {
            result[r][c] = original[i]
            c++
            if (c % n == 0) {
                r++; c = 0
            }
        }
        
        return result
    }
}