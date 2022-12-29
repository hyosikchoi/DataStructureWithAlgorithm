package com.hyosik.android.datastructurewithalgorithm.algorithm.binarySearch

/**
 * 이진 탐색
 * 장점 : 특정값에 대해 탐색을 할 때 O(logn) 의 시간복잡도를 보장한다.
 * 단점 : 값의 범위가 정해진 리스트에 있어서 무조건 정렬이 되있어야 한다.
 */
fun main() {
    val arr = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    println(binarySearch(arr = arr , target = 3 , start = 0 , end = arr.lastIndex))
}

private fun binarySearch(arr : IntArray , target : Int , start : Int , end : Int) : Int? {

    if(start > end) return null

    val mid = (start + end) / 2

    return if(arr[mid] == target) {
        mid
    } else if(target > arr[mid]) {
        binarySearch(arr , target , mid + 1 , end)
    } else {
        binarySearch(arr , target , start , mid - 1)
    }

}



