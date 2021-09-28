class Solution {
    fun longestAwesome(s: String): Int {
        
        val n = s.length
        val digitMask = mutableMapOf<Int, Int>()
        for (i in 0..9) {
            digitMask[i] = (1 shl i)
        }

        val seen = IntArray(1024) { _ -> -1 }
        var (mask, ans) = listOf(0, 0)
        for (i in 0 until n) {
            val digit = s[i] - '0'
            mask = mask.xor(digitMask[digit]!!)
            if (mask != 0 && seen[mask] == -1)
                seen[mask] = i
            ans = maxOf(ans, i - seen[mask])
            for (bit in 0..9) {
                val tempMask = mask.xor((1 shl bit))
                if (tempMask == 0 || seen[tempMask] != -1)
                    ans = maxOf(ans, i - seen[tempMask])
            }
        }

        return ans
    }
}