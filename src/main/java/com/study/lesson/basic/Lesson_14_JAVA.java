package com.study.lesson.basic;

import com.study.lesson.basic.lesson14.JavaCountry;
import com.study.lesson.basic.lesson14.JavaPersonDto;

public class Lesson_14_JAVA {
    public static void main(String[] args) {
        // 1. Data Class
        JavaPersonDto person = new JavaPersonDto("John", 30);
        System.out.println(person.toString());

        // 2. Enum Class
        handleCountry(JavaCountry.KOREA);

        // 3. Sealed Class, Sealed Interface
        // (1) Sealed Class
        // - 상속이 가능하도록 추상클래스를 만드려고 하는데,
        //   외부에서는 이 클래스를 상속받지 못하게 하고 싶다.
        //   => 하위 클래스를 봉인한다.
        // - 컴파일 타임 때 하위 클래스의 타입을 모두 기억
        //   => 런타임 때 클래스 타입이 추가될 수 없다.
        // - Enum과 다른 점
        //   => 클래스를 상속 받을 수 있다.
        //   => 하위 클래스는 멀티 인스턴스가 가능하다.
    }

    private static void handleCountry(JavaCountry country) {
        if(country == JavaCountry.KOREA) {
            // TODO
        }

        if(country == JavaCountry.AMERICA) {
            // TODO
        }
    }
}
