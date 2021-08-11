class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        
        val adjList = mutableListOf<MutableList<Int>>()
        for (i in 0 until numCourses) {
            adjList.add(i, mutableListOf())
        }
        
        fun addEdge(a: Int, b: Int) {
            adjList[a].add(b)
        }
        
        for (pair in prerequisites) {
            addEdge(pair[1], pair[0])
        }
        
        System.out.println(adjList)
        val visited = Array(numCourses) { false }
        
        fun dfs(i: Int, tempVisited: Array<Boolean>): Boolean {
            
            if (tempVisited[i])
                return true
            if (visited[i])
                return false
            
            tempVisited[i] = true; visited[i] = true
            
            for (x in adjList[i]) {
                if (dfs(x, tempVisited))
                    return true
            }
            
            tempVisited[i] = false
            return false
        }
        
        for (i in 0 until numCourses) {
            val tempVisited = Array(numCourses) { false }
            if (dfs(i, tempVisited))
                return false
        }
        
        return true
    }
}