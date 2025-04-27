package com.study.lesson.basic

fun main() {
    // 1. 중첩 클래스의 종류
    // (1) static을 사용하는 중첩 클래스
    // - ☑️ 클래스 안의 클래스. 밖의 클래스 직접 참조 불가

    // (2) static을 사용하지 않는 중첩 클래스
    //    (a) 내부 클래스(innner class)
    //    - ☑️ 클래스 안의 inner 클래스, 밖의 클래스 직접 참조 가능

    // 2. 코틀린의 중첩 클래스와 내부 클래스
}

class House (
    private val address: String,
//    private val livingRoom: House.LivingRoom = LivingRoom(10.0)
    private val livingRoom: LivingRoom // inner class 사용 시
) {
    inner class LivingRoom(
        private val area: Double
    ) {
        // ☑️ 코틀린에서는 기본적으로 바깥 클래스를 참조하지 않는다.
        //    바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다.

        val address: String
            get() = this@House.address // ☑️ this@클래스명
    }
}