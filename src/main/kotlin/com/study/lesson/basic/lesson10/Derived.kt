package com.study.lesson.basic.lesson10

class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived Class")
    }
}