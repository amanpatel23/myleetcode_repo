typealias pii = Pair<Int, Int>
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        
        val n = nums.size
        val result = mutableListOf<Int>()
        val dq: Deque<pii> = LinkedList<pii>()
        for (i in 0 until n) {
            while (dq.isNotEmpty() && dq.first().second <= (i - k))
                dq.removeFirst()
            while (dq.isNotEmpty() && dq.last().first < nums[i])
                dq.removeLast()
            dq.addLast(Pair(nums[i], i))
            if (i >= (k - 1))
                result.add(dq.first().first)
        }
        
        return result.toIntArray()
    }
}