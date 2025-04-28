package com.study.lesson.basic

import com.study.lesson.basic.lesson14.*

/* LESSON 14. 코틀린에서 다양한 클래스를 다루는 방법 */

fun main() {
    // 1. Data Class
    val person = PersonDto("John", 20)
    val person2 = PersonDto("David", 20)
    println(person.hashCode()) // hashCode
    println(person2.hashCode()) // hashCode
    println(person == person2) // equals
    println(person) // toString

    // 2. Enum Class
    handleCountry(Country.KOREA)

    // 3. Sealed Class, Sealed Interface
    // (1) Sealed Class
    // - 상속이 가능하도록 추상클래스를 만드려고 하는데,
    //   외부에서는 이 클래스를 상속받지 못하게 하고 싶다.
    //   => 하위 클래스를 봉인한다.
    // - 컴파일 타임 때 하위 클래스의 타입을 모두 기억
    //   => 런타임 때 클래스 타입이 추가될 수 없다.
    // - Enum과 다른 점
    //   => 클래스를 상속 받을 수 있다.
    //   => 하위 클래스는 멀티 인스턴스가 가능하다.
    handleCar(Avante())
    // ☑️ 추상화가 필요한 Entity, DTO 에 Sealed class 활용 추천
}

fun handleCountry(country: Country) {
    when(country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
        Country.ADDITIONAL -> TODO() // ☑️ 추가 enum 미작성 시 when에 에러 발생
        // else -> TODO() // 작성 필요 없음
    }
}

fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}