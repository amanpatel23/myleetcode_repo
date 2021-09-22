class Solution {
    fun sumGame(num: String): Boolean {
        
        val n = num.length
        var (fHalf, sHalf, x1, x2) = listOf(0, 0, 0, 0)
        for (i in 0 until (n / 2)) {
            if (num[i] == '?')
                x1++
            else
                fHalf += (num[i] - '0')
        }
        
        for (i in (n / 2) until n) {
            if (num[i] == '?')
                x2++
            else
                sHalf += (num[i] - '0')
        }
        
        val x = x1 + x2
        if (x and 1 == 1)
            return true
        
        val temp1 = fHalf + (minOf(x / 2, x1) * 9)
        val temp2 = sHalf + (minOf(x / 2, x2) * 9)
        if (temp1 != temp2)
            return true
        
        return false
    }
}