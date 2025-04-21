package com.study.lesson.basic

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/* LESSON 07. 코틀린에서 예외를 다루는 방법 */

fun main() {
    // 1. try-catch-finally 구문
    //parseIntOrThrow("123A")
    //parseIntOrThrowV2("456A")

    // 2. Checked Exception 과 Unchecked Exception
    readFile()

    // 3. try with resources (JDK 7 추가)
    // => Kotlin에서는 try with resources 구문은 존재하지 않음
    // => ☑️ use 라는 inline 함수 사용
    readFile2("./a.txt")
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt() // ☑️ 기본 타입간 컨버팅은 to~를 사용한다.
    } catch(e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}

fun parseIntOrThrowV2(str: String): Int? {
//    try {
//        return str.toInt()
//    } catch(e: NumberFormatException) {
//        return null
//    }
    return try { // ☑️ 코틀린에서는 try-catch도 Expression으로 사용 가능
        str.toInt()
    } catch(e: NumberFormatException) {
        null
    }
}

fun readFile() {
    // ☑️ 자바 코드와의 차이점은 throws IOException
    // ☑️ 코틀린에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다.
    // => 모두 Unchecked Exception

    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

fun readFile2(path: String) {
    BufferedReader(FileReader(path)).use {
        reader -> println(reader.readLine())
    }
}