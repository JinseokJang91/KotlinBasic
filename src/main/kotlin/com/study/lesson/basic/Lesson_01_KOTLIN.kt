package com.study.lesson

import com.study.lesson.Lesson_01_JAVA.Person

/* 코틀린에서 변수를 다루는 방법 */
fun main() {
    // ⭐ 코틀린은 모든 변수는 val, 필요한 경우만 var 사용 권고

    // 1. 가변
    var num1 = 10L; // var : variable
    num1 = 20L;

    // 2. 불변
    val num2 = 10L; // val : value
    //num2 = 20L; // ⚠️ERROR

    // ☑️ 타입은 컴파일러가 추론함. 단, 따로 설정도 가능
    var num1_1: Long = 10L;
    val num2_1: Long = 10L;

    // ☑️ 초기화
    //var num1_2 // ⚠️ERROR
    var num1_3: Long
    //println(num1_3) // ⚠️ERROR (초기화되지 않음)
    num1_3 = 5;
    println(num1_3)

    // val도 동일하지만, val은 최초 한 번만 값 지정 가능
    //val num2_2 // ⚠️ERROR
    val num2_3: Long
    //println(num2_3) // ️⚠️ERROR (초기화되지 않음)
    num2_3 = 5
    println(num2_3)
    //num2_3 = 10 // ⚠️ERROR

    // ☑️ val 컬렉션에는 element 추가 가능

    // 3. Reference Type, Primitive Type 표현이 같음
    // => 내부적으로 primitive type으로 적절히 변환해서 처리해줌
    var num3_1 = 10L
    var num3_2 = 1_000L

    // ☑️ Reference Type으로 사용 시 NULL 처리
    //num3_2 = null // ⚠️ERROR

    var num3_3: Long = 1_000L
    //num3_3 = null // ⚠️ERROR

    var num3_4: Long? = 1_000L
    num3_4 = null

    // 4. 객체
    // ☑️ new 미사용
    var person = Person("홍길동");
}