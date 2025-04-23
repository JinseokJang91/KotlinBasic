package com.study.lesson.basic

import com.study.lesson.basic.lesson09.JavaPerson
import com.study.lesson.basic.lesson09.Person

/* LESSON 09. 코틀린에서 클래스를 다루는 방법 */

fun main() {
    // Person 참고 !!!

    // 1. 클래스와 프로퍼티
    val person = Person("홍길동", 50)
    println(person.name) // ☑️ getter
    person.age = 10 // ☑️ setter
    println("---------------------")

    // ☑️ Java 클래스도 .필드명 으로 getter, setter 사용이 가능
    val person2 = JavaPerson("홍길동", 50)
    println(person2.name)
    person2.age = 10
    println("---------------------")

    // 2. 생성자와 int
    val person3 = Person("홍길동")
    println(person3.name)
    println(person3.age)
    println("---------------------")

    val person4 = Person()
    println(person4.toString())
    println("---------------------")

    // 3. 커스텀 getter, setter

    // 4. backing field
}