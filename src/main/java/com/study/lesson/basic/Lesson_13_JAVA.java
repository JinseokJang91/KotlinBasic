package com.study.lesson.basic;

import com.study.lesson.basic.lesson13.JavaHouse;

public class Lesson_13_JAVA {
    public static void main(String[] args) {
        // 1. 중첩 클래스의 종류
        // (1) static을 사용하는 중첩 클래스
        // - 클래스 안에 static을 붙인 클래스. 밖의 클래스 직접 참조 불가
        JavaHouse house = new JavaHouse("제주도");
        System.out.println(house.getLivingRoom().getAddress());

        // (2) static을 사용하지 않는 중첩 클래스
        //    (a) 내부 클래스(innner class)
        //    - 클래스 안의 클래스, 밖의 클래스 직접 참조 가능
        //    (b) 지역 클래스(local class)
        //    - 메소드 내부에 클래스 정의
        //    (c) 익명 클래스(anonymous class)
        //    - 이름이 없는 클래스, 주로 인터페이스나 추상클래스를 상속받아 구현

        // 2. 코틀린의 중첩 클래스와 내부 클래스
    }
}
