package com.study.lesson.basic

/* LESSON 11. 코틀린에서 접근 제어를 다루는 방법 */

fun main() {
    /** ✅ Kotlin의 접근제어자
     * 1. public : 모든 곳에서 접근 가능
     * 2. protected : "선언된 클래스" 또는 하위 클래스에서만 접근 가능
     *    => 패키지를 namespace를 관리하기 위한 용도로만 사용, 가시성 제어에는 사용하지 않는다.
     * 3. internal : "같은 모듈"에서만 접근 가능
     *    => 모듈 : 한 번에 컴파일 되는 Kotlin 코드
     *             e.g. Gradle Source Set, Maven Project, IDEA Module 등
     * 4. private : 선언된 클래스 내에서만 접근 가능
     */

    // 1. 자바와 코틀린의 가시성 제어
    // ☑️ Kotlin의 기본 접근 지시어는 "public" 이다.

    // 2. 코틀린 파일의 접근 제어
    // ☑️ .kt 파일에 변수, 함수, 클래스 여러 개를 바로 만들 수 있다.
    /** ✅ .kt 파일의 접근 제어
     * 1. public : 기본값, 어디서든 접근 가능
     * 2. protected : 파일(최상단)에는 사용 불가능
     * 3. internal : 같은 모듈에서만 접근 가능
     * 4. private : 같은 파일 내에서만 접근 가능
     */

    // 3. 다양한 구성요소의 접근 제어
    // (1) 클래스 안의 멤버
    // => "Kotlin의 접근제어자"와 동일

    // (2) 생성자
    // => "Kotlin의 접근제어자"와 동일
    //    ☑️ 단, 생성자에 접근지시어를 붙이려면 constructor 사용 필요

    // (3) 프로퍼티
    // => "Kotlin의 접근제어자"와 동일
    //    ☑️ 단, getter/setter 동시에 부여하거나, getter/setter 따로 가시성 부여 가능 (Car 참고)

    // 4. Java와 Kotlin을 함께 사용할 경우 주의할 점
    // ☑️ internal은 바이트코드 상 public이 된다.
    //    그렇기 때문에 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있다.
    // ☑️ Kotlin의 protected와 Java의 protected는 다르다.
    //    Java는 같은 패키지의 Kotlin protected 멤버에 접근할 수 있다.
}

class Car(
    internal val name: String, // getter를 interval
    private var owner: String, // getter/setter를 private
    _price: Int
) {
    var price = _price
        private set // setter를 private
}