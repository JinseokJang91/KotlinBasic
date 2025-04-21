package com.study.lesson.basic;

import java.util.Arrays;
import java.util.List;

public class Lesson_06_JAVA {
    public static void main(String[] args) {
        // 1. for-each문(향상된 for문)
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for(long number : numbers) {
            System.out.println(number);
        }
        System.out.println("----------");

        // 2. 전통적인 for문
        // (1) 올라가는 경우
        for(int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
        System.out.println("----------");
        // (2) 내려가는 경우
        for(int i = 3; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("----------");
        // (3) 두 칸씩 올라가는 경우
        for(int i = 0; i <= 6; i += 2) {
            System.out.println(i);
        }
        System.out.println("----------");

        // 3. Progression과 Range

        // 4. while문
        int i = 1;
        while(i <= 3) {
            System.out.println(i);
            i++;
        }
    }

}
