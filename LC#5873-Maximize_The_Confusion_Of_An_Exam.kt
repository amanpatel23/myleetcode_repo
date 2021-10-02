class Solution {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {

        val n = answerKey.length
        var x = k

        val qq: Queue<Char> = LinkedList<Char>()

        // converting 'F' to 'T'
        var i = 0
        var result = 0
        var currLen = 0
        while (i < n) {
            if (answerKey[i] == 'T') {
                qq.add('T')
                currLen++
                result = maxOf(result, currLen)
                i++
                continue
            }

            if (x > 0) {
                qq.add('F')
                currLen++
                result = maxOf(result, currLen)
                x--
                i++
                continue
            }

            val front = qq.poll()
            currLen--
            if (front == 'F')
                x++
        }
        
        qq.clear()
        
        // converting 'T' to 'F'
        currLen = 0
        x = k
        i = 0
        while (i < n) {
            if (answerKey[i] == 'F') {
                qq.add('F')
                currLen++
                result = maxOf(result, currLen)
                i++
                continue
            }

            if (x > 0) {
                qq.add('T')
                currLen++
                result = maxOf(result, currLen)
                x--
                i++
                continue
            }

            val front = qq.poll()
            currLen--
            if (front == 'T')
                x++
        }
        
        return result
    }
}