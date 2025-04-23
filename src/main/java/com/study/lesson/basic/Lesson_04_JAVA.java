package com.study.lesson.basic;

import com.study.lesson.basic.lesson04.JavaMoney;

public class Lesson_04_JAVA {
    public static void main(String[] args) {
        // 1. 단항 연산자 / 산술 연산자
        // (1) 단항 연산자 : ++, --
        // (2) 산술 연산자 : +, -, *, /, %
        // (3) 산술대입 연산자 : +=, -=, *=, /=, %=

        // 2. 비교 연산자와 동등성, 동일성
        // (1) 비교 연산자 : >, <, >=, <=
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);

        if(money1.compareTo(money2) > 0) {
            System.out.println("money1 > money2");
        }
        // (2) 동등성(Equality) : 두 객체의 값이 같은가?
        // (3) 동일성(Identity) : 두 객체는 완전히 동일한 객체인가? (= 주소가 같은가?)

        // Java : 동등성에 "equals", 동일성에 "==" 호출
        // Kotlin : 동등성에 "==" ("equals" 간접 호출), 동일성에 "==="

        JavaMoney money3 = new JavaMoney(1_000L);
        JavaMoney money4 = money3;
        JavaMoney money5 = new JavaMoney(1_000L);
        // 레퍼런스 비교
        System.out.println(money3 == money4); // true
        System.out.println(money3 == money5); // false
        // 값 비교 (equals 메소드 직접 구현, amount 비교)
        System.out.println(money3.equals(money4)); // true
        System.out.println(money3.equals(money5)); // true

        // 3. 논리 연산자
        // (1) 논리 연산자 : &&, ||, !
        // => ☑️ 자바와 동일, 자바와 동일하게 Lazy 연산 수행
        if(fun1() || fun2()) {
            System.out.println("Main Context");
        }

        // 4. 연산자 오버로딩
        JavaMoney money6 = new JavaMoney(1_000L);
        JavaMoney money7 = new JavaMoney(2_000L);
        System.out.println(money6.plus(money7).toString()); // JavaMoney(amount=3000)
    }

    public static boolean fun1() {
        System.out.println("fun 1");
        return true;
    }

    public static boolean fun2() {
        System.out.println("fun 2");
        return false;
    }
}
