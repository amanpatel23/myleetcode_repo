class Solution {
    fun longestStrChain(words: Array<String>): Int {
        
        val lenToStr = mutableMapOf<Int, MutableList<String>>()
        for (i in 1..16) {
            lenToStr[i] = mutableListOf()
        }
        for (str in words)
            lenToStr[str.length]!!.add(str)

        System.out.println(lenToStr)
        val dp = mutableMapOf<String, Int>()
        var count = 0
        fun longestChain(i: Int, prevStr: String, prevStrLen: Int): Int {
            count++
            if (i >= 17)
                return 0

            if (dp.containsKey(prevStr))
                return dp[prevStr]!!

            var ans = 0
            for (str in lenToStr[i]!!) {
                if (isSubsequence(str, prevStr, prevStrLen))
                    ans = maxOf(ans, 1 + longestChain(i + 1, str, i))
            }

            dp[prevStr] = ans
            return ans
        }
    
        var ans = 0
        for (i in 1..16) {
            for (str in lenToStr[i]!!) {
                ans = maxOf(ans, 1 + longestChain(i + 1, str, i))
            }
        }
        
        System.out.println(count)
        return ans
    }
    
    fun isSubsequence(str1: String, str2: String, len2: Int): Boolean {
        var idx = 0
        for (char in str1) {
            if (str2[idx] == char)
                idx++

            if (idx == len2)
                return true
        }

        return false
    }
}