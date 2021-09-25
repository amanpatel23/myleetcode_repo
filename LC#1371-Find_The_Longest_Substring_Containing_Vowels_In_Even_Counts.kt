class Solution {
    fun findTheLongestSubstring(s: String): Int {
        val n = s.length
        val vowelsMask = mapOf('a' to 1, 'e' to 2, 'i' to 4, 'o' to 8, 'u' to 16)
        val seen = Array(32) { -1 }
        var (mask, ans) = listOf(0, 0)
        for (i in 0 until n) {
            mask = mask.xor(vowelsMask.getOrDefault(s[i], 0))
            if (mask != 0 && seen[mask] == -1)
                seen[mask] = i
            ans = maxOf(ans, i - seen[mask])
        }

        return ans
    }
}