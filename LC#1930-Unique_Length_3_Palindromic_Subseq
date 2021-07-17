class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        
        val n = s.length
        
        val left = mutableSetOf<Char>()
        val right = Array<Int>(26) { 0 }
        
        left.add(s[0])
        for (i in 2 until n) {
            val idx = s[i] - 'a'
            right[idx]++
        }
        
        val ans = mutableSetOf<String>()
        for (i in 1 until (n - 1)) {
           for(ele in left) {
               if(right[ele - 'a'] > 0) {
                   val tempStr = StringBuilder()
                   tempStr.append(ele)
                   tempStr.append(s[i])
                   tempStr.append(ele)
                   ans.add(tempStr.toString())
               }
           }
           
           left.add(s[i])
           val idx = (s[i + 1] - 'a')
           right[idx]--
        
        }
        
        return ans.size
    }
}