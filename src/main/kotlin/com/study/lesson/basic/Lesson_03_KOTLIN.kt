package com.study.lesson

import com.study.lesson.Lesson_01_JAVA.*

// 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.
// e.g.1. val num = 3L // Long
// e.g.2. val num = 3.0f // Float

// 3. 코틀린의 특이한 타입 3가지
// ⭐ Any
// (1) Java의 Object 역할 (모든 객체의 최상위 타입)
// (2) 모든 Primitive Type의 최상의 타입도 Any
// (3) Any 자체로는 null을 포함할 수 없음. 포함하고 싶다면 Any?로 표현
// (4) Any에는 equals / hashCode / toString 존재

// ⭐ Unit
// (1) Java의 void와 동일한 역할
// (2) void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
// (3) 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미
//     즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현

// ⭐ Nothing
// (1) 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
// (2) 무조건 예외를 반환하는 함수 / 무한 루프 함수 등
// => 실제 코딩 시 많이 사용하지는 않음

fun main() {
    // 1. KOTLIN - 기본 타입 간 변환은 명시적으로 이루어져야 한다.
    // => to변환타입() 사용 toLong(), toDouble(), ...
    val num1 = 4
    //val num2: Long = num1 // Type Mismatch
    //println(num1 + num2) // ⚠️Compile Error
    val num3: Long = num1.toLong()
    println(num1 + num3)

    val num4: Int? = 3
    //val num5: Long = num4.toLong() // ⚠️Error
    val num6: Long = num4?.toLong() ?: 0L // Safe Call, Elvis 연산자 사용

    // 4. String Interpolation / String Indexing
    // ☑️ 변수 출력 시 달러 + 중괄호 사용
    val person = Person("홍길동")
    println("이름은 ${person.name}입니다.")

    val name = "임꺽정"
    println("이름은 $name 입니다.") // 바로 사용도 가능 (참고)

    // ☑️ 여러줄의 문자열 입력 시 쌍따옴표 3개 사용
    var str = """
        ABC
        123
        456
        ${person.name}
    """.trimIndent()
    println(str)

    // ☑️ 문자열의 특정 문자 가져오기 - 배열 Index와 같이 사용
    var str2 = "ABCDE"
    println(str2[1])
}

// 2. KOTLIN - 타입 캐스팅
fun printAgeIfPerson(obj: Any) {
    if(obj is Person) {
        val person = obj as Person // ☑️ as Person 생략 가능 (아래 조건문 확인)
        println(person.name)
    }

    if(obj is Person) {
        println(obj.name) // ☑️ 스마트 캐스팅
    }

    if(obj !is Person) { // ☑️ !is : is not

    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person // as? : 안전한 타입 형변환
    //println(person.name) // ⚠️Error (NPE)
    println(person?.name)
}