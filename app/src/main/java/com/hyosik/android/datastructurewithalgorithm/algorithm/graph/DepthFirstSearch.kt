package com.hyosik.android.datastructurewithalgorithm.algorithm.graph

import java.util.*

// 정점
data class Vertex(
    val value : String = "",
    val adjacent_vertices : MutableList<Vertex> = mutableListOf()
) {
    // 간선 추가
    fun addAdjacentVertex(vertex: Vertex) {
        adjacent_vertices.add(vertex)
    }

    // 간선 제거
    fun removeAdjacentVertex(vertex: Vertex) {
        if(adjacent_vertices.contains(vertex)) adjacent_vertices.remove(vertex)
    }

}


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

    DFS(vertex = ben , visited_vertices = visited)

}


private fun DFS(vertex: Vertex , visited_vertices : Hashtable<String,Boolean>) {
    /** 방문한 곳은 true 로 한다. */
    visited_vertices[vertex.value] = true

    println("정점 : ${vertex.value}")

    /** 방문한 정점의 간선으로 연결된 정점중 방문하지 않은곳이 있다면 깊이탐색 추가로 진행 */
    vertex.adjacent_vertices.forEach { v ->
        if(visited_vertices[v.value] == false) DFS(vertex = v , visited_vertices = visited_vertices)
    }
}
