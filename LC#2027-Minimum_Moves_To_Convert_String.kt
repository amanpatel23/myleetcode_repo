class Solution {
    fun minimumMoves(s: String): Int {

        var n = s.length
        var result = 0
        var i = 0
        while (i < n) {
            if (s[i] == 'O') {
                i++
                continue
            }
            
            result++
            i += 3
        }
        
        return result
    }
}