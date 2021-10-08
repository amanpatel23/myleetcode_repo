
class Solution {
    fun pancakeSort(arr: IntArray): List<Int> {

        val n = arr.size
        val result = mutableListOf<Int>()
        for (i in n downTo 1) {
            if (arr[i - 1] == i)
                continue
            var k1 = arr.indexOf(i) + 1
            result.add(k1)
            reverse(arr, 0, k1)
            result.add(i)
            reverse(arr, 0, i)
        }

        return result
    }
    
    fun reverse(arr: IntArray, st: Int, finish: Int) {
        var (i, j) = listOf(st, finish - 1)
        while (i <= j) {
            arr[i] = arr[j].also { arr[j] = arr[i] }
            i++
            j--
        }
    }
}