package com.study.lesson.basic.lesson10

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int // ☑️ 프로퍼티 override 시 open 필수
) {
    abstract fun move()
}