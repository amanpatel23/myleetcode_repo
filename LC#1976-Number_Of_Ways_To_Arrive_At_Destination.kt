class Solution {
    
    val mod = (1e9 + 7).toInt()
    
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        
        val adjList = mutableListOf<MutableList<Pair<Int, Int>>>()
        for (i in 0 until n) {
            adjList.add(mutableListOf())
        }
        
        fun addEdge(u: Int, v: Int, w: Int) {
            adjList[u].add(Pair(v, w))
            adjList[v].add(Pair(u, w))
        }
        
        for (edge in roads) {
            addEdge(edge[0], edge[1], edge[2])
        }
        
        val result = dijkstras(n, adjList)
        return result
    }
    
    fun dijkstras(n: Int, adjList: MutableList<MutableList<Pair<Int, Int>>>): Int {

        val visited = Array(n) { false }
        val dist = Array(n) { (1e15).toLong() }
        val ways = Array(n) { 0 }
        dist[0] = 0; ways[0] = 1

        val pq: PriorityQueue<Pair<Long, Int>> = PriorityQueue(compareBy { it.first })
        pq.add(Pair(0, 0))

        while (pq.isNotEmpty()) {

            val u = pq.peek().second; val weight = pq.peek().first
            pq.remove()

            visited[u] = true
            if (dist[u] < weight)
                continue

            for (x in adjList[u]) {
                val (v, w) = listOf(x.first, x.second)
                if (visited[v])
                    continue

                val newWt = dist[u] + w + 0L
                if (newWt < dist[v]) {
                    dist[v] = newWt
                    ways[v] = ways[u]
                    pq.add(Pair(newWt, v))
                }else if (newWt == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod
                }
            }
        }

        return ways[n - 1]
    }
}