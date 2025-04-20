package com.study.lesson.basic;

import static com.study.lesson.basic.Lesson_01_JAVA.Person;

public class Lesson_03_JAVA {
    public static void main(String[] args) {
        // 1. JAVA - 기본 타입 간 변환은 암시적으로 이루어질 수 있다.
        int num1 = 4;
        long num2 = num1;
        System.out.println(num1 + num2);

        // 4. String Interpolation / String Indexing
        // 변수 출력
        Person person = new Person("홍길동");
        String log = String.format("이름은 %s입니다.", person.getName());

        // 여러줄의 문자열 출력
        StringBuilder str = new StringBuilder();
        str.append("ABC").append("\n").append("123").append("\n");

        // 문자열의 특정 문자 가져오기
        String str2 = "ABCDE";
        char ch = str.charAt(1);
    }

    // 2. JAVA - 타입 캐스팅
    public static void printAgeIfPerson(Object obj) {
        if(obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }
}
