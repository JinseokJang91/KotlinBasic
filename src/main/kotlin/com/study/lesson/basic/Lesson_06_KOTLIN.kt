package com.study.lesson.basic

/* LESSON 06. 코틀린에서 반복문을 다루는 방법 */

fun main() {
    // 1. for-each문(향상된 for문)
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) { // ☑️ 콜론(:) 대신 in 사용
        println(number)
    }
    println("----------")

    // 2. 전통적인 for문
    // (1) 올라가는 경우
    for(i in 1..3) { // ☑️ i 범위를 ..로 표시
        println(i)
    }
    println("----------")
    // (2) 내려가는 경우
    for(i in 3 downTo 1) { // ☑️ 내려가는 경우 downTo 활용
        println(i)
    }
    println("----------")
    // (3) 두 칸씩 올라가는 경우
    for(i in 0..6 step 2) {
        println(i)
    }
    println("----------")

    // 3. Progression과 Range
    // IntProgression : 등차수열 (시작값, 끝값, 공차)
    // IntRange 는 IntProgression 상속 받고 있다.

    // downTo, step은 함수이다. (중위 호출 함수)
    // => [변수.downTo(Args)] 대신 [변수 downTo Args] 방식으로 사용

    // 4. while문
    // => do-while도 동일
    var i = 1
    while(i <= 3) {
        println(i)
        i++
    }
}