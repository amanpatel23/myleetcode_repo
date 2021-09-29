class Solution {
    
    val iMax = (1e9).toInt()
    fun minFlips(s: String): Int {
        
        val n = s.length
        val suffix1 = IntArray(n + 2) { _ -> 0 }
        val suffix2 = IntArray(n + 2) { _ -> 0 }
        val prefix1 = IntArray(n + 1) { _ -> 0 }
        val prefix2 = IntArray(n + 1) { _ -> 0 }
        
        // 1010...
        // 0101...
        
        for (i in n downTo 1) {
            if (i and 1 == 1) {
                suffix1[i] = suffix1[i + 1] +  (if (s[i - 1] == '1') 0 else 1)
                suffix2[i] = suffix2[i + 1] + (if (s[i - 1] == '0') 0 else 1)
            }else {
                suffix1[i] = suffix1[i + 1] + (if (s[i - 1] == '0') 0 else 1)
                suffix2[i] = suffix2[i + 1] + (if (s[i - 1] == '1') 0 else 1)
            }
        }
        
        for (i in 1..n) {
            if (i and 1 == 1) {
                prefix1[i] = prefix1[i - 1] + (if (s[i - 1] == '1') 0 else 1)
                prefix2[i] = prefix2[i - 1] + (if (s[i - 1] == '0') 0 else 1)
            }else {
                prefix1[i] = prefix1[i - 1] + (if (s[i - 1] == '0') 0 else 1)
                prefix2[i] = prefix2[i - 1] + (if (s[i - 1] == '1') 0 else 1)
            }
        }
        
        var result = iMax
        for (i in 1..n) {
            if (n and 1 == 0)
                result = minOf(result, suffix1[i] + prefix1[i - 1], suffix2[i] + prefix2[i - 1])
            else
                result = minOf(result, suffix1[i] + prefix2[i - 1], suffix2[i] + prefix1[i - 1])
        }
        
        return result
    }
}