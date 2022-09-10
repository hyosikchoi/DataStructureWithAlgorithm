package com.hyosik.android.datastructurewithalgorithm.datastructure

import java.util.*


fun main() {
    val hashTable : Hashtable<Int, String> = Hashtable()

    /** hashtable 은 각 키 별로 10을 나눈 나머지에 value 를 저장한다. */
    /** 나머지가 1이라고 치면 1 11 21 31 key 값으로 linkedList 처럼 연결 되있다. */
    /** value 를 찾게 될때 해당 키 값을 루프돌면서 값을 찾는다.(O(N) 의 성능) */
    hashTable.set(20,"홍명보")
    hashTable.set(21,"박지성")
    hashTable.set(6,"유상철")
    hashTable.set(1,"이운재")
    hashTable.set(4,"최진철")
    hashTable.set(22,"송종국")
    hashTable.set(5,"김남일")
    hashTable.set(10,"이영표")
    hashTable.set(9,"설기현")
    hashTable.set(14,"이천수")

    println(hashTable.get(20))
    println(hashTable.get(21))
    println(hashTable.get(6))
    println(hashTable.get(1))
}