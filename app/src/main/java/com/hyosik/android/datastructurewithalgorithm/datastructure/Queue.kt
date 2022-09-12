package com.hyosik.android.datastructurewithalgorithm.datastructure

import java.util.*


fun main() {

    val q : Queue<Int> = LinkedList<Int>()

    q.add(1)
    q.add(2)
    q.add(3)
    q.add(4)
    q.add(5)

    println(q.poll()) // 현재 tail 부분 노드 dequeue 한다.
    println(q.first()) // 현재 tail 부분 노드를 가져온다.
    println(q.elementAt(1)) // Queue 안에 index 의 노드를 가져온다. (tail 기점으로 index 0 으로 시작)
    println(q.last()) // 현재 head 부분 노드를 가져온다.
    println(q.peek()) // stack 에서는 head 였지만 queue 에서는 tail 부분 노드를 가져온다.
    println(q.isEmpty()) // Queue 가 비었는지 판단한다.


}