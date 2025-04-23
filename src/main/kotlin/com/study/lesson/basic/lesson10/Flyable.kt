package com.study.lesson.basic.lesson10

interface Flyable {
    fun act() {
        println("파닥 파닥")
    }

    // ✅ 추상 메소드
    fun fly()
}