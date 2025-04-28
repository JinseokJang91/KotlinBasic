package com.study.lesson.basic

/* LESSON 15. 코틀린에서 배열과 컬렉션을 다루는 방법 */

fun main() {
    // 1. 배열
    val array = arrayOf(100, 200)
    array.plus(300) // ☑️ 배열에 값 추가

    // ☑️ 배열 출력방법 (1)
    for(i in array.indices) {
        println("${i} ${array[i]}")
    }
    // ☑️ 배열 출력방법 (2)
    for((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    // 2. 코틀린에서의 Collection - List, Set, Map
    // - 컬렌션 생성 시 불변, 가변 여부를 반드시 설정해줘야 한다.
    //   - 가변 컬렉션 (Mutable Collection) : 컬렉션에 element를 추가, 삭제할 수 있다.
    //   - 불변 컬렉션 (Immutable Collection) : 컬렉션에 element를 추가, 삭제할 수 없다.

    // ✅ List
    // - 기본 구현체는 ArrayList
    // (1) 불변 리스트
    val numbers = listOf(100, 200) // ☑️ listOf<Int>(100, 200) 와 같음
    //numbers.add(300) // ⚠️ ERROR 불변 리스트이므로 추가 불가
    // (a) 단일 값
    println(numbers.get(0))
    println(numbers[0])
    // (b) 향상된 for문 (for-each 문)
    for(num in numbers) {
        println(num)
    }
    // (c) 일반 for문
    for((idx, value) in numbers.withIndex()) {
        println("${idx} ${value}")
    }

    // (2) 가변 리스트
    val numbers2 = mutableListOf(100, 200)
    numbers2.add(300)

    // ⭐ TIP. 불변 리스트 생성 후, 필요한 경우 가변 리스트로 바꿔서 사용할 것

    val emptyList = emptyList<Int>() // ☑️ 비어있는 리스트 생성 시 타입 명시해야 한다.
    printNumbers(emptyList()) // ☑️ 단, 타입이 추론 가능하면 생략 가능하다.

    // ✅ Set
    // - 기본 구현체는 LinkedHashSet
    val numbersSet = setOf(100, 200)
    //numbersSet.add(300) // ⚠️ ERROR 불변 Set이므로 추가 불가
    val numbersSet2 = mutableSetOf(100, 200)
    numbersSet2.add(300)

    for(num in numbers) {
        println(num)
    }

    for((index, value) in numbers.withIndex()) {
        println("$index $value")
    }

    // ✅ Map
    val oldMap = mutableMapOf<Int, String>() // ☑️ 타입이 추론 가능하면 생략 가능하다.
    oldMap.put(1, "MONDAY")
    oldMap[2] = "TUESDAY"
    println(oldMap)

    val newMap = mapOf(1 to "MONDAY", 2 to "TUESDAY")
    println(newMap)

    // ☑️ 출력 방식
    for(key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for((key, value) in newMap.entries) {
        println(key)
        println(value)
    }

    // 3. 컬렉션의 null 가능성, Java와 함께 사용할 때 주의할 점
    // (1) List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
    // (2) List<Int>? : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
    // (3) List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음

    // ☑️ Kotlin에서 Java 컬렉션을 가져다 사용할 때 플랫폼 타입을 신경써야 한다.
    // => Java 코드를 보며 맥락을 확인하고, Java 코드를 가져오는 지점을 wrapping 한다.
}

private fun printNumbers(numbers: List<Int>) {

}