package com.study.lesson.basic;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Lesson_01_JAVA {
    public static void main(String[] args) {
        // 1. 가변
        long num1 = 10L;

        // 2. 불변
        final long num2 = 10L;

        final List<Integer> nums = new ArrayList<>();
        // Collection은 final로 선언해도 element 추가 가능
        nums.add(1);

        // 3. Reference Type (Primitive Type : long)
        Long num3 = 1_000L;

        // 4. 객체
        Person person = new Person("홍길동");
    }

    public static class Person {
        private final String name;

        public Person(String name) {
            this.name = name;
        }

        @Nullable
        // ☑️ @NotNull 사용 시 Lesson_02_KOTLIN.kt 26 line 에러 사라짐
        // ☑️ 어노테이션 미사용 시에는 코틀린에서 null이 아니라고 추정
        //    단, 실제 null 사용 시에는 Runtime 시 NPE 발생함
        //    (Lesson_02_KOTLIN.kt 27 line에 "홍길동" 대신 null 사용 시 NPE 발생)
        public String getName() {
            return name;
        }
    }
}
