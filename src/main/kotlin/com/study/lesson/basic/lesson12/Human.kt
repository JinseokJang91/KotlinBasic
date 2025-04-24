package com.study.lesson.basic.lesson12

class Human private constructor (
    var name: String,
    var age: Int
) {
    // ☑️ 코틀린에는 static 존재하지 않음
    // => companion object 블록에 선언
    companion object Factory : Log {
        // ✅ const
        // - 진짜 상수에 붙이기 위한 용도
        // - 기본 타입과 String에 붙일 수 있음

        // private val MIN_AGE = 1      // ☑️ const 미사용 => 런타임 시 변수 할당
        private const val MIN_AGE = 1   // ☑️ const 사용 => 컴파일 시 변수 할당

        @JvmStatic
        fun newBaby(name: String): Human {
            return Human(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Human 클래스의 동반 객체이다.")
        }
    }
    /** ✅ companion object (동반 객체)
     * - 하나의 객체로 간주됨
     * - 이름을 붙일 수 있음 => e.g. Factory
     * - interface 구현 가능
     * - 유틸성 함수 구현도 가능하나, 최상단 파일 활용 추천
     */
}

object Singleton {
    var a: Int = 0
}