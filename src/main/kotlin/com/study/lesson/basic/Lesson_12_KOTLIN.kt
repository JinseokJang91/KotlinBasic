package com.study.lesson.basic

import com.study.lesson.basic.lesson12.Movable
import com.study.lesson.basic.lesson12.Singleton

/* LESSON 12. 코틀린에서 Object 키워드를 다루는 방법 */

fun main() {
    // 1. static 함수와 변수

    // 2. 싱글톤
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    // 3. 익명 클래스
    // ☑️ Java   => new 타입이름()
    // ☑️ Kotlin => object : 타입이름
    moveSomething(object : Movable {
        override fun move() {
            println("움직입니다..")
        }

        override fun fly() {
            println("날아갑니다~~")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}