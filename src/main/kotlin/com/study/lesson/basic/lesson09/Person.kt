package com.study.lesson.basic.lesson09

// ☑️ 클래스 명에 public 생략 가능
// ☑️ 생성자 constructor 생략 가능
// public class Person constructor(name: String, age:Int){
/*
class Person (name: String, age: Int){
//    val name: String = name
//    var age: Int = age

    // ☑️ 필드의 타입이 생성자에 명시되어 있으므로 생략 가능
    val name = name
    var age = age

    // ☑️ 코틀린에서는 getter, setter 자동으로 만들어 준다.
}
 */

// ☑️ 코틀린에서는 생성자에 바로 필드 선언이 가능 (Java record와 비슷한듯?)
// ☑️ body 부가 비어있으면 중괄호 {} 생략 가능
class Person (val name: String, var age: Int) { // ☑️ 주생성자 (primary constructor)
    // ☑️ init 블록 : 클래스가 초기화 되는 시점에 한 번 호출
    init {
        // ✅ 검증 로직 (age)
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        println("주생성자")
    }

    // ✅ 새로운 생성자 - constructor 선언 후 생성 가능
    constructor(name: String) : this(name, 1) { // ☑️ 부생성자 (secondary constructor)
        // ☑️ 부생성자에는 body 생성 가능
        // ☑️ 부생성자는 최종적으로 주생성자를 호출해야 한다.
        println("부생성자 1")
    }

    constructor() : this("홍길동") {
        // 부생성자 2는 부생성자 1을 호출, 부생성자 1은 주생성자를 호출
        println("부생성자 2")
    }

    // ⭐ 코틀린에서 부생성자 사용보다는 default parameter 사용을 권장
    // => 부생성자는 Converting(A객체 => B객체) 시 사용할 수 있지만,
    //    그 대신 정적 팩토리 메소드 사용 추천

    // ✅ 성인 검증 함수
    // 첫 번째 방법
    /*
    fun isAdult(): Boolean {
        return this.age >= 20
    }
     */

    // 두 번째 방법 (프로퍼티처럼 생성)
    val isAdult: Boolean
        get() = this.age >= 20

    val isAdult2: Boolean
        get() {
            return this.age >= 20
        }

    // ☑️ backing field 대신 사용 가능한 방법
    /*
    fun getUppercaseName(): String {
        return this.name.uppercase()
    }
     */

    val uppercaseName: String
        get() = this.name.uppercase()


    // toString()
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

// ☑️ 주생성자의 getter를 없애고, custom getter 만들기
// => name 호출 시 uppercase로 변환하는 getter
class Person2(name: String = "hong gil dong", var age: Int = 1) {
//    val name = name // ⚠️ERROR
//        get() = name.uppercase()

    // ☑️ field : 무한루프를 막기위한 예약어 - backing field
    // => backing field가 빈번하게 사용되지는 않음
    // => 함수로 처리 가능 or
    val name = name
        get() = field.uppercase()
}

// ☑️ 주생성자의 setter를 없애고, custom setter 만들기
// => name 세팅 시 uppercase로 변환하는 setter
class Person3(name: String = "hong gil dong", var age: Int = 1) {
    // backing setter도 자주 사용하지 않음
    var name = name
        set(value) {
            field = value.uppercase()
        }
}

// 생성자도 생략해서 생성 가능
class Student