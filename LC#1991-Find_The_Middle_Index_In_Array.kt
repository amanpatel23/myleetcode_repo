class Solution {
    fun findMiddleIndex(nums: IntArray): Int {
        
        val n = nums.size
        
        var result = -1
        var (leftSum, rightSum) = listOf(0, nums.sum())
        for (i in 0 until n) {
            rightSum -= nums[i]
            if (leftSum == rightSum) {
                result = i
                break
            }

            leftSum += nums[i]
        }
        
        return result
    }
}