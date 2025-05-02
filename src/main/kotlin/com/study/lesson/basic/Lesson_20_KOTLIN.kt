package com.study.lesson.basic

/* LESSON 20. 코틀린의 scope function */

fun main() {
    // 1. scope function 이란 무엇인가?
    // scope : 영역
    // function : 함수
    // ☑️ scope function : 일시적인 영역을 형성하는 함수

    // 2. scope function 의 분류
    val person = Person20("홍길동", 30)

    // ☑️ let : 람다의 결과 반환, it 사용
    // ☑️ run : 람다의 결과 반환, this 사용
    // ☑️ also : 객체 그 자체를 반환, it 사용
    // ☑️ apply : 객체 그 자체를 반환, this 사용
    // ☑️ with : 확장함수는 아님, this를 사용해 접근하고, this는 생략 가능하다.
    val value1 = person.let { it.age + 20 }
    println(value1) // 50
    val value2 = person.run { this.age + 20 }
    println(value2) // 50
    val value3 = person.also { it.age + 20 }
    println(value3) // Person20(name=홍길동, age=30)
    val value4 = person.apply { this.age + 20 }
    println(value4) // Person20(name=홍길동, age=30)
    val value5 = Person20("임꺽정", 50)
    with(value5) {
        println(name)
        println(this.age)
    }

    // ☑️ it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다. 일반 함수를 받는다.
    val value6 = person.let { s -> s.age + 30}
    println(value6)
    // ☑️ this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다. 확장 함수를 받는다.
    val value7 = person.run { age + 30 }
    println(value7)

    // 3. 언제 어떤 scope function 을 사용해야 할까?
    // ☑️ let
    //   ✅ 하나 이상의 함수를 call chain 결과로 호출 할 때
    val strings = listOf("APPLE", "CAR", "FRUIT")
    strings.map { it.length }
        .filter { it > 3 }
        .let (::println) // = .let { lengths -> println(lengths) }
    //   ✅ non-null 값에 대해서만 code block을 실행시킬 때 (제일 많이 사용)
    val str = "apple"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
    println(length)
    //   ✅ 일회성으로 제한된 영역에 지역 변수를 만들 때
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if(firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)
    println("--------------------------------")

    // ☑️ run
    //   ✅ 객체 초기화와 반환값의 계산을 동시에 해야할 때 (잘 사용하지 않음)
    /*
    val person = Person20("홍길동", 30).run(personRepository::save) // Person DB 저장 후 해당 객체 반환
     */
    /*
    val person = Person("홍길동", 30).run {
      hobby = "독서"
      personRepository.save(this) // Person DB 저장 시 hobby 변경값 적용 후 해당 객체 반환
    }
     */

    // ☑️ also
    //   ✅ 객체를 수정하는 로직이 call chain 중간에 필요할 때
    val numbers2 = mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one : $it") }
        .add("four")
    println(numbers2)
    println("--------------------------------")

    val numbers3 = mutableListOf("one", "two", "three")
    println("The list elements before adding new one : $numbers3")
    numbers3.add("four")
    println(numbers3)
    println("--------------------------------")

    // ☑️ apply
    //   ✅ 객체 설정 시 객체를 수정하는 로직이 call chain 중간에 필요할 때
    val person20 = createPerson20("홍길동", 30, "컴퓨터게임")
    println(person20)
    println("--------------------------------")

    // ☑️ with
    //   ✅ 특정 객체를 다른 객체로 변환해야 하는데,
    //      모듈 간의 의존성에 의해 정적 팩토리 또는 toClass 함수를 만들기 어려울 때
    /*
    return with(person {
      PersonDto(
        name = name,
        age = age
      )
    }
    => this를 생략할 수 있어 필드가 많아도 코드가 간결해진다.
     */

    // 4. scope function 과 가독성
    // 1번 코드
    /*
    if (person != null && person.isAdult) {
      view.showPerson(person)
    } else {
      view.showError()
    }
     */
    // 2번 코드 (코틀린스러운 코드)
    /*
    person?.takeIf { it.isAdult }
      ?.let(view::showPerson)
      ?: view.showError()
     */

    // 1번 코드가 가독성이 더 좋음. 디버깅도 더 좋음. 수정도 더 쉬움
}

class Person20(
    val name: String,
    val age: Int,
) {
    var hobby: String = ""

    override fun toString(): String {
        return "Person20(name='$name', age=$age, hobby='$hobby')"
    }
}

fun printPerson(person: Person20?) {
    if(person != null) {
        println(person.name)
        println(person.age)
    }
}

fun printPersonScope(person: Person20?) {
    // ☑️ let : scope function의 한 종류
    person?.let { // Safe Call 사용 (?.)
        println(it.name)
        println(it.age)
    }
}

fun createPerson20(
    name: String,
    age: Int,
    hobby: String,
): Person20 {
    // Test Fixture 만들 때 생성자에 존재하지 않는 hobby 선언
    return Person20(
        name = name,
        age = age,
    ).apply {
        this.hobby = hobby // 주석 처리 시 "컴퓨터게임" 출력되지 않음.
    }
}