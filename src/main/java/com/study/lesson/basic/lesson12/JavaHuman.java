package com.study.lesson.basic.lesson12;

public class JavaHuman {
    private static final int MIN_AGE = 1;

    // ☑️ 정적 팩토리 메소드
    public static JavaHuman newBaby(String name) {
        return new JavaHuman(name, MIN_AGE);
    }

    private String name;
    private int age;

    public JavaHuman(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
