package com.study.lesson.basic.lesson10

interface Swimable {
    // ☑️ Kotlin에서는 backing field 없는 프로퍼티를 인터페이스에 만들 수 있다.
    val swimAbility: Int
        get() = 5

    fun act() {
        println("어푸 어푸")
        println("펭귄의 능력치는 ${swimAbility}이다.")
    }
}