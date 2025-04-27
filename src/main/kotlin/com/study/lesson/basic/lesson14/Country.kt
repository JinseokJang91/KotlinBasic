package com.study.lesson.basic.lesson14

enum class Country (
    private val code: String,
){
    KOREA("KO"),
    AMERICA("US"),

    ADDITIONAL("test") // ☑️ enum 추가 등록시 when 구문에 오류 발생
    ;
}