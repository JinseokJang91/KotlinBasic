package com.study.lesson.basic.lesson18

data class Fruit18 (
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long
) {
    fun nullOrValue(): Int? { // 멤버함수
        return if(this.currentPrice > 1200) {
            this.currentPrice.toInt()
        } else {
            null
        }
    }

    // ☑️ 출고가와 현재가가 동일한 과일 고르기 리팩토링
    //    => (1) 출고가와 현재가가 같은지 확인하는 로직
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}