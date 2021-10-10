class Solution {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {

        val result = mutableSetOf<Int>()
        for (x in nums1) {
            for (y in nums2) {
                if (x == y)
                    result.add(x)
            }
        }
        for (x in nums1) {
            for (y in nums3) {
                if (x == y)
                    result.add(x)
            }
        }
        for (x in nums2) {
            for (y in nums3) {
                if (x == y)
                    result.add(x)
            }
        }
        
        return result.toList()
    }
}