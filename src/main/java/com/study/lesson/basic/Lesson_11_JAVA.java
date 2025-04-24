package com.study.lesson.basic;

import com.study.lesson.basic.lesson11.StringUtilsKt;

public class Lesson_11_JAVA {
    public static void main(String[] args) {
        /** Java의 접근제어자
         * 1. public : 모든 곳에서 접근 가능
         * 2. protected : 같은 패키지 또는 하위 클래스에서만 접근 가능
         * 3. default : 같은 패키지에서만 접근 가능
         * 4. private : 선언된 클래스 내에서만 접근 가능
         */

        // 1. 자바와 코틀린의 가시성 제어
        // ☑️ Java의 기본 접근 지시어는 "default" 이다.

        // 2. 코틀린 파일의 접근 제어

        // 3. 다양한 구성요소의 접근 제어
        boolean isPath = StringUtilsKt.isDirectoryPath("path"); // .kt 파일 접근
        System.out.println("isPath = " + isPath);

        // 4. Java와 Kotlin을 함께 사용할 경우 주의할 점
    }

}
