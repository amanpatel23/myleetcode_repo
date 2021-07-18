class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        
        val strArr = mutableListOf<String>()
        strArr.addAll(text.split(" ").toList())
        val brokenArr = Array<Int>(26) { 0 }
        
        for(char in brokenLetters) {
            val temp = char - 'a'
            brokenArr[temp] = 1
        }
        
        var result = 0
        for(str in strArr) {
            var flag = true
            for(char in str) {
                if(brokenArr[char - 'a'] == 1) {
                    flag = false
                    break
                }
            }
            
            if(flag)
                result++
        }
        
        return result
    }
}