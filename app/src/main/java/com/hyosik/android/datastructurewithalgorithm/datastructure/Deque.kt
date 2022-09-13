package com.hyosik.android.datastructurewithalgorithm.datastructure

import java.util.*

fun main() {

    val d : Deque<Int> = LinkedList<Int>()

    d.addFirst(1) // [1]
    d.addFirst(2) // [2,1]
    d.addFirst(3) // [3,2,1]
    d.addLast(4)  // [3,2,1,4]
    d.addLast(5)  // [3,2,1,4,5]

    println(d) // printAll()

    d.removeFirst() // [2,1,4,5]
    d.removeLast() // [2,1,4]

    println(d)

    println("isEmpty : ${d.isEmpty()}")

}