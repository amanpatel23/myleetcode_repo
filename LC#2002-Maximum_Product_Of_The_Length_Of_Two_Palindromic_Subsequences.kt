class Solution {
    
    val iMin = (-1e9).toInt()
    fun maxProduct(s: String): Int {
        val len = s.length
        
        val palList = mutableListOf<Pair<Int, Int>>()
        fun extractPal(i: Int, str: String, n: Int, mask: Int) {
            
            if (i >= len) {
                if (checkPal(str, n))
                    palList.add(Pair(n, mask))
                return
            }
            
            extractPal(i + 1, str, n, mask)
            extractPal(i + 1, str + s[i], n + 1, mask or (1 shl i))
            
            return
        }
        
        extractPal(0, "", 0, 0)
        
        val n = palList.size
        var result = iMin
        for (i in 0 until n) {
            for (j in (i + 1) until n) {
                if (notSharedIdx(palList[i].second, palList[j].second))
                    result = maxOf(result, palList[i].first * palList[j].first)
            }
        }
        
        return result
    }
    
    fun isSet(num: Int, bit: Int): Boolean {
        return (num and (1 shl bit)) > 0
    }
    
    fun notSharedIdx(mask1: Int, mask2: Int): Boolean {
        for (bit in 0..30) {
            if (isSet(mask1, bit) && isSet(mask2, bit))
                return false
        }
        return true
    }
    
    fun checkPal(s: String, n: Int): Boolean {
        if (n == 0)
            return false
        var (l, r) = listOf(0, n - 1)
        while (r - l > 0) {
            if (s[l] != s[r])
                return false
            l++; r--
        }
        return true
    }
}