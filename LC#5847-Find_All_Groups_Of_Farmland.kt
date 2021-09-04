class Solution {
    fun findFarmland(_land: Array<IntArray>): Array<IntArray> {
        
        val land = _land
        val (m, n) = listOf(land.size, land[0].size)
        
        val resultList = mutableListOf<IntArray>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (land[i][j] == 1) {
                    val coord = IntArray(4)
                    var (gff, gss) = listOf(i, j)
                    
                    fun dfs(i: Int, j: Int) {
                        
                        if (i >= m || j >= n || land[i][j] == 0)
                            return
                        
                        land[i][j] = 0
                        
                        if (i >= gff && j >= gss) {
                            gff = i; gss = j
                        }
                        
                        dfs(i, j + 1)
                        dfs(i + 1, j)
                    }
                    
                    dfs(i, j)
                    coord[0] = i; coord[1] = j; coord[2] = gff; coord[3] = gss;
                    resultList.add(coord)
                }
            }
        }
        
        for (coord in resultList) {
            System.out.println(coord.contentToString())
        }
        
        val len = resultList.size
        val resultArr = Array(len) { IntArray(4) }
        for (i in 0 until len) {
            resultArr[i] = resultList[i]
        }
        
        return resultArr
    }
}