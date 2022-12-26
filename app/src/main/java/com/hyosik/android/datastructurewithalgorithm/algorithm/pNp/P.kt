package com.hyosik.android.datastructurewithalgorithm.algorithm.pNp

/**
 * 결정론적 튜링 머신으로 다항시간(ex O(n^2),O(n^3)등 ) 내에 답을 찾을 수 있는 문제
 * 보통 쉬운 문제
 */

/**
 * ex) 정렬
 */
fun main() {

    val arr = intArrayOf(3,4,1,2,5)

    bubbleSort(arr)
    arr.forEach {
        print("$it ")
    }
}

private fun bubbleSort(arr : IntArray) {
    for(i in 0 until arr.size - 1) {
        for(j in 0 until arr.size - i - 1) {
            if(arr[j] > arr[j+1]) {
                arr[j] = arr[j] xor arr[j+1]
                arr[j+1] = arr[j] xor arr[j+1]
                arr[j] = arr[j] xor arr[j+1]
            }
        }
    }
}