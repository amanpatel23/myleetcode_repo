class Solution {
    
    val mod = 1_000_00_00_07
    val dp = Array(1005) {IntArray(1024) { -1 }}
    var m = -1
    var n = -1
    
    fun colorTheGrid(_m: Int, _n: Int): Int {
        m = _m
        n = _n
        
        return solve(0, 0)
    }
    
    fun solve(idx: Int, prevColMask: Int): Int {
        
        if (idx == n)
            return 1
        
        if (dp[idx][prevColMask] != -1)
            return dp[idx][prevColMask]
        
        var ans = 0
        val conf = mutableListOf<Int>()
        dfs(0, prevColMask, 0, conf)
        for (ele in conf) {
            ans = (ans + solve(idx + 1, ele) % mod) % mod
        }
        
        dp[idx][prevColMask] = ans;
        return ans;
    }
    
    fun getColor(mask: Int, pos: Int): Int {
        return ((mask shr (2 * pos)) and 3)
    }
    
    fun setColor(mask: Int, pos: Int, color: Int): Int {
        return (mask or (color shl (2 * pos)))
    }
    
    fun dfs(row: Int, prevColMask: Int, currColMask: Int, conf: MutableList<Int>): Unit {
        
        if (row == m) {
            conf.add(currColMask)
            return
        }
        
        for (i in 1..3) {
            if (getColor(prevColMask, row) != i && (row == 0 || getColor(currColMask, row - 1) != i)) {
                dfs(row + 1, prevColMask, setColor(currColMask, row, i), conf)
            }
        }
        
        return
    }
}