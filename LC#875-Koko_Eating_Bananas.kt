class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        val n = piles.size
        var (l, r) = listOf(1, (1e9).toInt())
        fun check(k: Int): Boolean {
            var hrs = 0
            for (i in 0 until n) {
                hrs += (piles[i].ceilDiv(k))
            }

            return (hrs <= h)
        }
        while (r - l > 1) {
            val mid = l + ((r - l) / 2)
            if (check(mid))
                r = mid
            else
                l = mid
        }

        val result = if (check(l)) l else r
        return result
    }
    
    infix fun Int.ceilDiv(other: Int): Int = (this + other - 1) / other
}