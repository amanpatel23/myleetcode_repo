class Solution {
    fun missingRolls(rolls: IntArray, mean: Int, _n: Int): IntArray {

        val m = rolls.size
        val sum = rolls.sum()

        var n = _n
        var x = ((m + n) * mean) - sum
        if (x !in n..(6 * n)) {
            return emptyArray<Int>().toIntArray()
        }

        val result = IntArray(n) { _ -> -1 }
        var idx = 0
        while (n > 0) {
            val temp = x / n
            result[idx] = temp
            x -= temp
            n--
            idx++
        }

        return result
    }
}