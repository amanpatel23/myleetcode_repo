typealias pii = Pair<Int, Int>
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        val n = nums.size
        val result = mutableListOf<Int>()
        val comp = Comparator { o1: pii, o2: pii -> o2.first - o1.first }
        val pq: PriorityQueue<pii> = PriorityQueue(comp)
        
        for (i in 0 until k)
            pq.add(Pair(nums[i], i))
        result.add(pq.peek().first)
        
        for (i in k until n) {
            pq.add(Pair(nums[i], i))
            while (true) {
                val top = pq.peek()
                if (top.second !in (i - k + 1)..i) {
                    pq.remove()
                    continue
                }
                
                result.add(top.first)
                break
            }
        }
        
        return result.toIntArray()
    }
}