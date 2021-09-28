class Solution {
    fun wonderfulSubstrings(word: String): Long {
        
        val n = word.length
        var state = 0
        var ans = 0L
        val seen = IntArray(1024) { _ -> 0 }
        seen[0] = 1
        for (i in 0 until n) {
            val digit = word[i] - 'a'
            state = state.xor(1 shl digit)
            if (seen[state] > 0)
                ans += seen[state]
            for (bit in 0..9) {
                val tempState = state.xor(1 shl bit)
                if (seen[tempState] > 0)
                    ans += seen[tempState]
            }

            //out.println(ans)
            seen[state]++
        }

        return ans
    }
}