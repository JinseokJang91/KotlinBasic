package com.study.lesson.basic

/* LESSON 08. 코틀린에서 함수를 다루는 방법 */

fun main() {
    // 1. 함수 선언 문법
    val result1 = max(1, 2)
    println(result1)
    val result2 = maxMoreSimple(1, 2)
    println(result2)
    val result3 = maxMostSimple(1, 2)
    println(result3)

    // 2. default parameter
    // => Kotlin에서는 default 값 설정이 가능
    repeat("Hello") // ☑️ 2, 3번째 파라미터를 입력하지 않아도 기본값이 설정되어 호출 가능
    println("--------------")
    repeat("Hello", 5)
    println("--------------")
    repeat("Hello", 5, false)
    println("--------------")

    // 3. named argument (parameter)
    // => 매개변수 이름을 통해 직접 지정 (e.g. useNewLine)
    // => 지정되지 않은 매개변수는 기본값 사용 (e.g. num)
    repeat("Hello", useNewLine = false) // ☑️ useNewLine : named argument 설정
    println("--------------")

    // ☑️ builder를 만들지 않고 builder의 장점을 가질 수 있다.
    printNameAndGender(name = "홍길동", gender = "MALE")

    // ☑️ Java 함수를 가져다 사용하는 경우에는 named argument 사용 불가
    // => 코틀린에서 Java 코드 사용 시 JVM 상에서 Java가 바이트코드로 변환되었을 때
    //    Parameter Name을 보존하지 않으므로 사용이 불가능하다.
    //Lesson_08_JAVA.repeat(str = "HELLO") // ⚠️ ERROR

    // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
    val array = arrayOf("A", "B", "C")
    printAll(*array) // ☑️ 가변인자 사용 시 *(spread 연산자) 사용 필요

    printAll("A", "B", "C")
}

fun max(a:Int, b:Int): Int {
    /*
    if(a > b) {
        return a
    }
    return b
    */
    // ☑️ Expression 으로 전환 가능
    return if(a > b) {
        a
    } else {
        b
    }
}

// ☑️ max 함수를 더 간단한 Expression 으로 전환 가능
// => 리턴이 하나의 값이므로 "="를 사용해서 축약 가능
fun maxMoreSimple(a:Int, b:Int): Int =
    if(a > b) {
        a
    } else {
        b
    }
// ☑️ maxMoreSimple 함수를 더 간단한 Expression 으로 전환 가능
// => 결과는 무조건 Int 이므로 생략 가능, if문 중괄호도 생략 가능
fun maxMostSimple(a:Int, b:Int) = if(a > b) a else b

fun repeat (
    str: String,
    num: Int = 3, // ☑️ num 기본값 설정
    useNewLine: Boolean = true // ☑️ useNewLine 기본값 설정
) {
    for(i in 1..num) {
        if(useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

fun printAll(vararg strings: String) { // ☑️ 타입... 을 사용하지 않고 "vararg" 사용
    for(str in strings) {
        println(str)
    }
}