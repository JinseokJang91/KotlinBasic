package com.study.lesson.basic

fun main() {
    // 1. if문
    // validateScoreIsNotNegative(-10) // ⚠️ 예외 발생

    // 2. Expression과 Statement
    // ☑️ if-else는 Java에서는 Statement, Kotlin에서는 Expression
    // Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
    // Expression : 하나의 값으로 도출되는 문장
    val result1 = getPassOrFail(50)
    println("result1 = ${result1}")

    // ☑️ if-else if-else 문도 if-else와 동일하게 Expression으로 취급
    val result2 = getGrade(75)
    println("result2 = ${result2}")

    // ☑️ 조건에 범위를 사용하는 경우, Kotlin에서만 사용할 수 있는 a..b를 활용하면 더 편리하다.
    val score = 70
    if(0 <= score && score <= 100) {
        println("점수는 0점과 100점 사이이다. -- (1)")
    }
    if(score in 0..100) {
        println("점수는 0점과 100점 사이이다. -- (2)")
    }
    val score2 = 120
    if(score2 !in 0..100) {
        println("점수는 0점과 100점 사이가 아니다. -- (3)")
    }

    // 3. switch와 when
    // => ☑️ Kotlin에서는 switch-case문은 존재하지 않음. 대신 when 구문 사용
    // when (값) {
    //  조건부 -> 어떠한 구문
    //  조건부 -> 어떠한 구문
    //  else -> 어떠한 구문
    // => ☑️ 조건부에는 어떠한 Expression이라도 들어갈 수 있다. (e.g. is Type)
    // => ☑️ 여러개의 조건을 동시에 검사할 수 있다. ("," 로 구분)
    // => ☑️ (값) 이 없을 수도 있다 => early return 처럼 동작
    // => ☑️ when은 Enum Class 또는 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다.
}

// ☑️ Java와 차이
// (1) 함수 생성 시 fun 사용
// (2) void 생략
// (3) Exception new 생략
fun validateScoreIsNotNegative(score: Int) {
    if(score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int): String {
//    if(score >= 50) {
//        return "PASS"
//    } else {
//        return "FAIL"
//    }
    // ☑️ Kotlin에서는 if-else문이 Expression이므로 return 절에 사용 가능하다.
    return if(score >= 50) {
        "PASS"
    } else {
        "FAIL"
    }
}

fun getGrade(score: Int): String {
    return if(score >= 90) {
        "A"
    } else if(score >= 80) {
        "B"
    } else if(score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun getGradeWithSwitch(score: Int): String {
    // 사용방법 1
//    return when(score / 10) {
//        9 -> "A"
//        8 -> "B"
//        7 -> "C"
//        else -> "D"
//    }
    // 사용방법 2
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when(obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when(number) {
        1, 0, -1 -> println("1, 0, -1 중 하나입니다.")
        else -> println("1, 0, -1 이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}