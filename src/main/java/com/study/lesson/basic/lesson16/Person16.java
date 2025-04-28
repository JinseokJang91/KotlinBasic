package com.study.lesson.basic.lesson16;

public class Person16 {
    private final String firstName;
    private int age;

    public Person16(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int nextYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }

    public int getAge() {
        return age;
    }
}
