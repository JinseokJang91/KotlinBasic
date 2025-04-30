package com.study.lesson.basic

import com.study.lesson.basic.lesson18.Fruit18

// ☑️ as import - CASE
import com.study.lesson.basic.lesson19.a.printHelloWorld as printHelloWorldA
import com.study.lesson.basic.lesson19.b.printHelloWorld as printHelloWorldB

/* LESSON 19. 코틀린의 이모저모 */

fun main() {
    // 1. Type Alias와 as import
    // ☑️ Type Alias
    //   - 긴 이름의 클래스 혹은 함수 타입이 있을 때 축약하거나 다른 이름을 쓰고 싶을 때 사용
    // ☑️ as import
    //   - 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶을 때 사용
    //   - 어떤 클래스나 함수를 import 할 때 이름을 바꾸는 기능
    printHelloWorldA()
    printHelloWorldB()

    // 2. 구조분해와 componentN 함수
    // ☑️ 구조분해
    //   - 복합적인 값을 분해하여 여러 변수를 한 번에 초기화 하는 것
    val person = Person19("홍길동", 30)
    val (name, age) = person
    println("이름 : ${name}, 나이 : ${age}")
    // ☑️ componentN (N은 숫자)
    //   - 위의 val (name, age) 는 실제로 아래 component 함수를 가져온 것이다.
    //   - data class는 field에 대해서 componentN 함수를 만들어준다.
    //   - 선언한 프로퍼티 순서대로 component1(), component2(), ... 로 가져올 수 있다.
    val name2 = person.component1()
    val age2 = person.component2()
    println("이름 : ${name2}, 나이 : ${age2}")

    val (name3, age3) = Person19_2("임꺽정", 40)
    println("이름 : ${name2}, 나이 : ${age2}")

    // 3. Jump와 Label
    // ☑️ return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다.
    // ☑️ break : 가장 가까운 루프가 제거된다.
    // ☑️ continue : 가장 가까운 루프를 다음 step으로 보낸다.
    // => Java와 동일하게 작동

    // 예외 CASE - forEach
    // => break, continue 사용 불가
    // => 사용하고 싶다면 run block 사용
    // => break, continue 사용 시 그냥 for문 사용 권장!!!
    val numbers = listOf(1, 2, 3)
    numbers.map { it + 1 }.forEach{ println(it) }
    println("---------------------")

    run {
        numbers.forEach { number ->
            if(number == 2) {
                return@run // ☑️ break와 같은 효과
            }
            println(number)
        }
    }
    println("---------------------")

    run {
        numbers.forEach { number ->
            if(number == 2) {
                return@forEach // ☑️ continue와 같은 효과
            }
            println(number)
        }
    }
    println("---------------------")

    // ☑️ Label
    //  - 특정 expression에 라벨이름@ 을 붙여 하나의 라벨로 간주
    //  - break, continue, return 등 사용
    //  - 코드 복잡도가 증가하므로 Jump와 Label은 사용하지 않는 것을 권장!!!
    abc@ for(i in 1..100) {
        for(j in 1..100) {
            if(j == 2) break@abc // 바깥 for문에 break가 걸려 종료됨
            println("${i} ${j}")
        }
    }
    println("---------------------")

    // 4. TakeIf와 TakeUnless
    // ☑️ takeIf : 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다.
    // ☑️ takeUnless : 주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null이 반환된다.
    println(getNumberOrNull(10))
    println(getNumberOrNull(-10))
    println(getNumberOrNullV2(20))
    println(getNumberOrNullV2(-20))
    println(getNumberOrNullV3(30))
    println(getNumberOrNullV3(-30))
}

// ☑️ Type Alias - CASE 1
fun filterFruits19(fruits: List<Fruit18>, filter: (Fruit18) -> Boolean) {

}

typealias FruitFilter19 = (Fruit18) -> Boolean

fun filterFruits19_2(fruits: List<Fruit18>, filter: FruitFilter19) {

}

// ☑️ Type Alias - CASE 2
data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

// ☑️ 구조분해 - CASE 1
data class Person19(
    val name: String,
    val age: Int
)

// ☑️ 구조분해 - CASE 2
//   - componentN 함수 직접 구현
class Person19_2(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun getNumberOrNull(number: Int): Int? {
    return if(number <= 0) {
        null
    } else {
        number
    }
}

fun getNumberOrNullV2(number: Int): Int? {
    return number.takeIf { num -> num > 0 }
}

fun getNumberOrNullV3(number: Int): Int? {
    return number.takeUnless { it <= 0 } // { num -> num <= 0 } 과 같음
}