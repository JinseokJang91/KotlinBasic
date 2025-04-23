package com.study.lesson.basic.lesson10

class Penguin(
    species: String,
    private val wingCount: Int = 2
    ) : Animal(species, 2), Swimable, Flyable {

    override fun move() {
        println("펭귄이 파닥파닥 거립니다.")
    }

    public override val legCount: Int // 추상 프로퍼티가 아니면 해닫 필드에 open을 붙여줘야 함(Animal 참고)
        get() = super.legCount + this.wingCount
    // ☑️ Animal의 legCount가 protected, 상위 클래스의 접근지시자를 따라간다.
    //    인스턴스 생성 후 legCount를 호출하려면 앞에 public을 붙여줘야 함.

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        println("[KOTLIN] fly 추상 메소드")
    }

    // ☑️ Kotlin에서는 backing field 없는 프로퍼티를 인터페이스에 만들 수 있다.
    //    => 여기서 getter를 구현해도 되고, 인터페이스 내에서 get()을 사용해 구현해도 됨
    //       (둘 다 선언 시 여기서 선언한 값이 최종 적용됨. 우선시 됨)
    override val swimAbility: Int
        get() = 3
}