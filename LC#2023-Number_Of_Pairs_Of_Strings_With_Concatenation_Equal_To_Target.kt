class Solution {
    fun numOfPairs(nums: Array<String>, target: String): Int {

        val n = nums.size
        val targetLen = target.length

        var result = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j)
                    continue

                val check = StringBuilder()
                check.append(nums[i])
                check.append(nums[j])
                if (check.toString() == target)
                    result++
            }
        }

        return result
    }
}