package com.hyosik.android.datastructurewithalgorithm.datastructure

import java.util.*

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    while(!stack.isEmpty()) {
        /** Stack 의 head 값을 출력 */
        println("peek : ${stack.peek()}")
        /** Stack 의 head 를 제거 */
        stack.pop()
    }
}