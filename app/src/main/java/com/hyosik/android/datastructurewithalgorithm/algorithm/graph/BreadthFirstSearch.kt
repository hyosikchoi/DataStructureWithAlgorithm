package com.hyosik.android.datastructurewithalgorithm.algorithm.graph

import java.util.*


fun main() {
    /** 방문한 곳 은 Hashtable 로 한다. (O(1)의 성능)  */
    val visited = Hashtable<String,Boolean>()

    val ben = Vertex(value = "Ben")
    val ivy = Vertex(value = "Ivy")
    val joy = Vertex(value = "Joy")
    val jake = Vertex(value = "Jake")
    val anna = Vertex(value = "Anna")
    val david = Vertex(value = "David")
    val elin = Vertex(value = "Elin")
    val owen = Vertex(value = "Owen")

    visited.set("Ben",false)
    visited.set("Ivy",false)
    visited.set("Joy",false)
    visited.set("Jake",false)
    visited.set("Anna",false)
    visited.set("David",false)
    visited.set("Elin",false)
    visited.set("Owen",false)

    ben.addAdjacentVertex(ivy)
    ben.addAdjacentVertex(jake)
    ben.addAdjacentVertex(anna)
    ben.addAdjacentVertex(david)

    ivy.addAdjacentVertex(ben)
    ivy.addAdjacentVertex(joy)

    joy.addAdjacentVertex(ivy)
    joy.addAdjacentVertex(jake)

    jake.addAdjacentVertex(ben)
    jake.addAdjacentVertex(joy)

    anna.addAdjacentVertex(ben)

    david.addAdjacentVertex(ben)
    david.addAdjacentVertex(elin)

    elin.addAdjacentVertex(david)
    elin.addAdjacentVertex(owen)

    owen.addAdjacentVertex(elin)

    BFS(vertex = ben, visited_vertices = visited)
}

/**
 * 1. 방문한 정점으로 저장하고 방문한 정점을 Queue에 삽입
 * 2. 큐에서 Dequeue
 * 3. Dequeue한 정점의 인접 정점을 순회.(만약 인접 정점이 이미 방문한 정점이라면 건너뛰고 방문하지 않은 정점이라면
 * 첫 번째 경우 반복)
 */
private fun BFS(vertex: Vertex , visited_vertices: Hashtable<String,Boolean>) {
    val queue : Queue<Vertex> = LinkedList()
    /** 1번 */
    visited_vertices[vertex.value] = true
    queue.add(vertex)

    while (queue.isNotEmpty()) {
       /** 2번 */
       val currentVertex =  queue.poll()

       println("정점 : ${currentVertex.value}")
        /** 3번 */
        currentVertex.adjacent_vertices.forEach { v ->
            if(visited_vertices[v.value] == false) {
                /** 1번 반복 */
                visited_vertices[v.value] = true
                queue.add(v)
            }
        }
    }
}