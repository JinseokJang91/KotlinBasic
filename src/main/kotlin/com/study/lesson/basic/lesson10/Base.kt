package com.study.lesson.basic.lesson10

open class Base (
    open val number: Int = 100
) {
   init {
       println("Base Class")
       println(number)
   }
}