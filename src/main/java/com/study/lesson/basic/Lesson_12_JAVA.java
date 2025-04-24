package com.study.lesson.basic;

import com.study.lesson.basic.lesson12.Human;
import com.study.lesson.basic.lesson12.Movable;

public class Lesson_12_JAVA {
    public static void main(String[] args) {
        // 1. static 함수와 변수
        // ☑️ 코틀린 동반 객체의 function 접근 시
        // (1) 동반 객체 이름이 없는 경우
        //Human.Companion.newBaby("DAVID");
        // (2) function에 @JvmStatic 어노테이션 사용하는 경우
        Human.newBaby("BOB");
        // (3) 동반 객체 이름이 있는 경우
        Human.Factory.newBaby("SALLY");

        // 2. 싱글톤
        // ☑️ 싱글톤 : 단 하나의 인스턴스만을 갖는 클래스

        // 3. 익명 클래스
        // ☑️ 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
        moveSomething(new Movable() {

            @Override
            public void move() {
                System.out.println("움직입니다..");
            }

            @Override
            public void fly() {
                System.out.println("날아갑니다~~");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
}
