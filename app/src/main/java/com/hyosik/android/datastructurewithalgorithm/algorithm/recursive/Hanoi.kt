package com.hyosik.android.datastructurewithalgorithm.algorithm.recursive

fun main() {

    /** 1.원반은 한번에 하나만 옮길 수 있다. */
    /** 2.원반 높은게 낮은거 위에 있으면 안된다. */
    /** 3.A -> C 로 위의 조건을 지켜 옮긴다. */
    hanoi(3,"A","C","B")

}


private fun hanoi(count : Int , from : String , to : String , use : String) {
    if(count == 0) return // 기저 조건으로 가장 낮은 숫자의 원반을 옮긴 것으로 둔다. (1번 부터 옮기게 된다.)
    hanoi(count = count -1 , from = from , to = use , use = to) // 3 위의 1,2 를 B로 옮긴다.
    println("원반 $count 를 $from 에서 $to 로 이동 시킨다.") // 3 을 C 로 옮긴다.
    hanoi(count = count -1 , from = use , to = to , use = from) // 1,2 를 C 로 옮긴다.
}