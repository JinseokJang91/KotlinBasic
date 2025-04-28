package com.study.lesson.basic.lesson16

fun main() {
    val person = Person16("A", 100)
    println(person.nextYearAge()) // Java 멤버 함수가 우선적으로 호출된다.
}

fun Person16.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}