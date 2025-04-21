package com.study.lesson.basic

/* LESSON 04. 코틀린에서 연산자를 다루는 방법 */

fun main() {
    // 1. 단항 연산자 / 산술 연산자
    // (1) 단항 연산자 : ++, --
    // (2) 산술 연산자 : +, -, *, /, %
    // (3) 산술대입 연산자 : +=, -=, *=, /=, %=
    // => ☑️ 자바와 코틀린 동일

    // 2. 비교 연산자와 동등성, 동일성
    // (1) 비교 연산자 : >, <, >=, <=
    // => ☑️ 자바와 코틀린 동일
    // => ☑️ 단, 비교 연산자 사용 시 자동으로 compareTo 호출 (객체 값 비교)
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if(money1 > money2) { // => money1.compareTo(money2) > 0
        println("money1 > money2")
    }
    // (2) 동등성(Equality) : 두 객체의 값이 같은가?
    // (3) 동일성(Identity) : 두 객체는 완전히 동일한 객체인가? (= 주소가 같은가?)

    // Java : 동등성에 "equals", 동일성에 "==" 호출
    // Kotlin : 동등성에 "==" ("equals" 간접 호출), 동일성에 "==="
    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)
    // 레퍼런스 비교
    println(money3 === money4) // true
    println(money3 === money5) // false
    // 값 비교 (equals 메소드 직접 구현, amount 비교)
    println(money3 == money4) // true (equals 호출)
    println(money3 == money5) // true (equals 호출)

    // 3. 논리 연산자 / 코틀린만의 특이한 연산자
    // (1) 논리 연산자 : &&, ||, !
    // => ☑️ 자바와 동일, 자바와 동일하게 Lazy 연산 수행
    // => ☑️ Lazy 연산 예시
    if(fun1() || fun2()) {
        println("Main Context") // fun1() 결과가 true => fun2() 실행하지 않음
    }
    // (2) 코틀린만의 특이한 연산자
    // ✅ in / !in
    // => ☑️ 컬렉션 또는 범위에 포함되어있는 지 여부
    // ✅ a..b
    // => ☑️ a부터 b까지의 범위 객체 생성
    // ✅ a[i]
    // => ☑️ a에서 특정 index i로 값을 가져옴
    // ✅ a[i] = b
    // => ☑️ a의 특정 index i에 b를 넣음

    // 4. 연산자 오버로딩
    // => ️ ☑️ 코틀린에서는 객체마다 연산자를 직접 정의할 수 있다.
    val money6 = KotlinMoney(1_000L)
    val money7 = KotlinMoney(2_000L)
    println(money6 + money7) // KotlinMoney(amount=3000)
    println(money6.plus(money7)) // KotlinMoney(amount=3000)


}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false;
}