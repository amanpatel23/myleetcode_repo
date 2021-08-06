class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        
        val charIdx = Array(150) { -1 }
        var range = Pair(0, 0)
        
        var result = 0
        for ((i, char) in s.withIndex()) {
            val ascii = char.toInt()
            if (charIdx[ascii] in range.first..range.second)
                range = Pair(charIdx[ascii] + 1, i)
            else
                range = Pair(range.first, i)
            
            charIdx[ascii] = i
            result = maxOf(result, range.second - range.first + 1)
        }
        
        return result
    }
}