package com.study.lesson.basic

import com.study.lesson.basic.lesson17.Fruit

/* LESSON 17. 코틀린에서 람다를 다루는 방법 */

// ⭐ 코틀린에서의 함수 : 1급 시민
// ⭐ 자바에서의 함수 : 2급 시민

fun main() {
    // 1. Java에서 람다를 다루기 위한 노력

    // 2. 코틀린에서의 람다
    // ☑️ Java와 근본적으로 다른 점
    //    => 코틀린에서는 함수가 그 자체로 값이 될 수 있다.
    //    => 변수에 할당할 수도, 파라미터로 넘길 수도 있다.
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    // ☑️ 람다(이름없는 함수)를 만드는 방법 1
    // => 함수명이 빠진 CASE
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // ☑️ 람다(이름없는 함수)를 만드는 방법 2
    // => 중괄호를 사용한 CASE
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    // ☑️ 람다(이름없는 함수)를 직접 호출하는 방법 1
    isApple(fruits[0])
    // ☑️ 람다(이름없는 함수)를 직접 호출하는 방법 2
    // => invoke 호출 후 사용
    isApple.invoke(fruits[0])

    // ☑️ 입력/반환 타입 표현
    // => 함수의 타입 : (파라미터 타입...) -> 반환 타입
    val isApple3: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple4: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    // ☑️ filterFruits 적용 예시
    // 기본
    filterFruits(fruits, isApple)
    // 파라미터처럼 사용되므로 함수를 바로 대입할 수도 있음
    filterFruits(fruits, fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    })

    // 기본
    filterFruits(fruits, isApple2)
    // 파라미터처럼 사용되므로 함수를 바로 대입할 수도 있음
    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    // 소괄호 안의 중괄호의 어색함을 해결하기 위해 밖으로 빼서 사용할 수 있음
    // 즉, 마지막 파라미터가 함수인 경우, 소괄호 밖에 람다 사용 가능
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    // 함수에서 filter: (Fruit) -> Boolean 으로 타입 추론이 가능하므로 Fruit 생략 가능
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    // 파라미터가 한 개인 경우, it 지시어를 사용해 간단하게 처리할 수 있음
    filterFruits(fruits) { it.name == "사과" }
    // 람다 여러줄 작성 시, 마지막 줄의 결과가 람다의 반환값이 됨
    filterFruits(fruits) {
        println("사과를 뽑아보자")
        it.name == "사과"
    }

    // 3. Closure
    var targetFruitName: String = "바나나"
    targetFruitName = "수박" // 코틀린에서는 에러 발생하지 않음
    // ☑️ 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
    //    => 이러한 데이터 구조를 Closure 라고 부른다.
    filterFruits(fruits) { it.name == targetFruitName }

    // 4. 다시 try with resources
    // ☑️ use 함수 : Closeable 구현체에 대한 확장함수, inline 함수, 람다를 받게 만들어진 함수
    //    => <T : Closeable?, R> -> 구현체
    //    => T.use -> 확장함수
    //    => public inline fun -> inline 함수
    //    => T.use(block: (T) -> R) -> 파라미터가 block, T타입 파라미터, R타입 반환타입
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if(filter(fruit)) { // 또는 filter.invoke(fruit) 사용 가능
            results.add(fruit)
        }
    }

    return results
}