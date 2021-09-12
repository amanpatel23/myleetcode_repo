class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        
        val first = word.indexOf(ch)
        if (first == -1)
            return word
        
        val result = StringBuilder()
        result.append(word.subSequence(0, first + 1).reversed())
        result.append(word.subSequence(first + 1, word.length))
        
        return result.toString()
    }
}