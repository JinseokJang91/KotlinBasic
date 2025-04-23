package com.study.lesson.basic.lesson10

// ☑️ 타입 사용 시 한 칸 띄지 않고 콜론(:) 사용 (e.g. species: String)
// ☑️ 상속 사용 시 한 칸 띄어서 콜론(:) 사용  (e.g. class Cat() : Animal)
class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("얼어붙은 한강 위로 고양이가 걸어다닙니다.")
    }
}