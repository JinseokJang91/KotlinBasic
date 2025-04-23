package com.study.lesson.basic

import com.study.lesson.basic.lesson10.*

/* LESSON 10. 코틀린에서 상속을 다루는 방법 */

fun main() {
    // 1. 추상 클래스
    //val animal = Animal("종") // ⚠️ ERROR 추상클래스는 인스턴스화 불가능 (JAVA 동일)

    val cat = Cat("고양이")
    println(cat.move())
    println("------------------------")
    val penguin = Penguin("펭귄")
    println(penguin.move())
    println("------------------------")
    println(penguin.legCount) // ☑️ Penguin legCount 접근지시자 변경 시 호출 가능
    println("------------------------")

    // ✅ 출력 시 보이는 Kotlin.Unit 은 함수 리턴타입이 Unit이어서 출력되는 것임
    //    => Unit은 Java의 void와 같으나 Kotlin에서는 그 형태가 존재 (Lesson_03_KOTLIN.kt 확인)

    // 2. 인터페이스
    //val swimable = Swimable() // ⚠️ ERROR 인터페이스는 인스턴스화 불가능 (JAVA 동일)

    val penguin2 = Penguin("펭귀인")
    println(penguin2.act())
    println("------------------------")
    println(penguin2.fly())
    println("------------------------")

    // 3. 클래스 상속 시 주의할 점
    Derived(300)
    /**
     * 상위클래스에서 하위클래스가 override 하고 있는 프로퍼티(즉, 상위클래스에서 open 처리한 필드)를
     * 생성자 block 또는 init block에서 사용 시 정확한 값이 도출되지 않는다.
     *
     * 출력 결과
     * Base Class
     * 0
     * Derived Class
     */
    println("------------------------")

    // 4. 상속 관련 지시어 (참고)
    /**
     * (1) final : override를 할 수 없게 한다. default로 보이지 않게 존재한다.
     * (2) open : override를 열어 준다.
     * (3) abstract : 반드시 override 해야 한다.
     * (4) override : 상위 타입을 오버라이드 하고 있다.
     */
}