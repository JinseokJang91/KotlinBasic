package com.study.lesson

import com.study.lesson.Lesson_01_JAVA.Person

/* 코틀린에서 null을 다루는 방법 */
fun main() {
    // ⭐ Safe call과 Elvis 연산자는 early return에도 유용하게 사용 가능

    // (1) Safe Call : 앞의 변수가 null이면 그대로 null이 됨
    val str: String? = "ABC"
    //println(str.length) // ⚠️ERROR
    println(str?.length) // 3

    var str2: String? = null
    println(str2?.length) // null

    // (2) Elvis 연산자 : 앞의 연산 결과가 null이면 뒤의 값을 사용
    var str3: String? = null
    println(str3?.length ?: 0) // 0

    // (3) null 아님 단언 : nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
    // startsWithB 확인

    // (4) 플랫폼 타입 : 코틀린이 null 관련 정보를 알 수 없는 타입. Runtime 시 예외 발생 가능
    // e.g. jakarta.annotation, android, jetbrains null 관련 Annotation 활용 시 코틀린에서 인식 가능
    // ☑️ Java와 Kotlin 혼용 시 Java 라이브러리를 가져다 쓸 때 null 관련 정보를 꼼꼼히 체크하는 것이 중요
    val person = Person("홍길동")
    //startsWithC(person.name) // ⚠️ERROR
}

// 1. 사용 불가
//fun startsWithA_NULL(str: String?): Boolean {
//    return str.startsWith("A") // ⚠️ERROR
//}

// 1. 사용 가능
fun startsWithA_NOTNULL(str: String): Boolean {
    return str.startsWith("A")
}

// 1-1. 예외 처리
fun startsWithA_1(str: String?): Boolean {
    /*
    if(str == null) {
        throw IllegalArgumentException("str is null")
    }

    return str.startsWith("A")
    */

    // Kotlin 활용해서 로직 변환 시
    return str?.startsWith("A") ?: throw IllegalArgumentException("str is null")
}

// 1-2. null 반환
fun startsWithA_2(str: String?): Boolean? {
    /*
    if(str == null) {
        return null
    }

    return str.startsWith("A")
     */

    return str?.startsWith("A")
}

// 1-3. false 반환
fun startsWithA_3(str: String?): Boolean {
    /*
    if(str == null) {
        return false
    }

    return str.startsWith("A")
    */

    return str?.startsWith("A") ?: false
}

// early return
fun calculate(num: Long?): Long {
    num ?: return 0

    // ... process ...

    return num
}

// null이 확실히 아닌 경우에만 !! 사용
// 만약 str에 null 사용 시 NPE 발생
fun startsWithB(str: String?): Boolean {
    //return str.startsWith("B") // ⚠️ERROR

    return str!!.startsWith("B")
}

fun startsWithC(str: String): Boolean {
    return str.startsWith("C")
}
