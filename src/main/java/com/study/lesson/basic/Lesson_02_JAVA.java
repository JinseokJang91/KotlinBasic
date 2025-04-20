package com.study.lesson.basic;

public class Lesson_02_JAVA {
    public static void main(String[] args) {

    }

    // 1. NPE 발생 가능
    public boolean startsWithA_NPE(String str) {
        return str.startsWith("A");
    }

    // 1-1. 예외 처리
    public boolean startsWithA_1(String str) {
        if(str == null) {
            throw new IllegalArgumentException("str is null");
        }

        return str.startsWith("A");
    }

    // 1-2. null 반환
    public Boolean startsWithA_2(String str) {
        if(str == null) {
            return null;
        }

        return str.startsWith("A");
    }

    // 1-3. false 반환
    public boolean startsWithA_3(String str) {
        if(str == null) {
            return false;
        }

        return str.startsWith("A");
    }

    // early return
    public long calculate(Long num) {
        if(num == null) {
            return 0;
        }

        // ... process ...

        return num;
    }
}
