package com.study.lesson.basic

import com.study.lesson.basic.lesson16.Srt
import com.study.lesson.basic.lesson16.Train
import com.study.lesson.basic.lesson16.isExpensive

/* LESSON 16. 코틀린에서 다양한 함수를 다루는 방법 */

fun main() {
    // ☑️ Kotlin은 Java와 100% 호환하는 것을 목표로 하고 있다.

    // 1. 확장함수
    // ☑️ 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없다.
    //    => 캡슐화가 깨지기 대문
    val str = "ABC"
    println(str.lastChar()) // C

    // ☑️ 해당 변수의 현재 타입(정적인 타입)에 의해 어떤 확장함수가 호출될 지 결정됨
    // => 생성하는 인스턴스 타입과는 무관하다.
    val train: Train = Train()
    train.isExpensive() // "Train의 확장함수"

    val srt1: Train = Srt()
    srt1.isExpensive() // "Train의 확장함수"

    val srt2: Srt = Srt()
    srt2.isExpensive() // "Srt의 확장함수"

    // 2. infix 함수 (중위함수)
    // ☑️ 함수를 호출하는 새로운 방법
    //    [변수.함수이름(args)] 대신 [변수 함수이름 args] 사용
    // ☑️ c.f. downTo, step 도 중위함수에 포함된다.
    // ☑️ infix 키워드는 확장함수 뿐만 아니라 멤버함수에도 붙여 사용할 수 있다.
    3.add(4)
    //3 add 4 // ⚠️ ERROR

    3.add2(4)
    3 add2 4

    // 3. inline 함수
    // ☑️ 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
    // ☑️ 함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다.
    // ☑️ inline 함수 사용은 성능 측정과 함께 신중하게 사용되어야 한다.
    3.add3(4)

    // 4. 지역함수
    // ☑️ 함수 안에 함수를 선언할 수 있다.
    // ☑️ depth가 깊어지고, 코드가 상대적으로 깔끔하지 않은 편이다.
    val person = Person("Kevin", "Jo", 10)
    println(person.toString())
}

// ☑️ 확장함수
// e.g. String 클래스 확장
// fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
//  // this를 이용해 실제 클래스 안의 값에 접근
// }
//
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// ☑️ 중위함수
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

inline fun Int.add3(other: Int): Int {
    return this + other
}

// ☑️ 지역함수
fun createPerson(firstName: String, lastName: String): Person {
    // 중복 코드
    /*
    if(firstName.isEmpty()) {
        throw IllegalArgumentException("firstName은 비어있을 수 없습니다. 현재 값 : $firstName")
    }

    if(lastName.isEmpty()) {
        throw IllegalArgumentException("lastName은 비어있을 수 없습니다. 현재 값 : $lastName")
    }
    */

    fun validateName(name: String, fieldName: String) {
        if(name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다. 현재 값 : $name")
        }
        validateName(firstName, "firstName")
        validateName(lastName, "lastName")
    }

    return Person(firstName, lastName, 1)
}

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int
)