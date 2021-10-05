class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        val n = nums.size
        val freq = mutableMapOf<Int, Int>()
        var result = 0
        var sum = 0
        freq[sum] = 1
        for (i in 0 until n) {
            sum += nums[i]
            val key = sum - k
            result += (freq[key]?.let { freq[key]!! } ?: 0)
            freq[sum] = freq[sum]?.let { freq[sum]!! + 1 } ?: 1
        }

        return result
    }
}