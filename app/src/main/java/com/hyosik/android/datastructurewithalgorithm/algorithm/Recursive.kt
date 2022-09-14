package com.hyosik.android.datastructurewithalgorithm.algorithm


fun main() {
    print(factorial(5))
}

private fun factorial(number : Int) : Int {
    if(number <= 1) {
        return number
    }

    /** recursive 를 사용해야 할 때는 같은 함수의 뭉탱이 다음 마지막 값 연산이 적용 되게끔 생각한다. */
    /** 예를 들어 지금처럼 팩토리얼 이라면 5!(factorial(5)) 은 마지막 5 * 4!(factorial(4)) 가 성립되는 것처럼말이다. */
    return number * factorial(number = number - 1)
}