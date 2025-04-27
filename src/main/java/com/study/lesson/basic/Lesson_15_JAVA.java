package com.study.lesson.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson_15_JAVA {
    public static void main(String[] args) {
        // 1. 배열
        int[] array = {100, 200};

        for(int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }

        // 2. 코틀린에서의 Collection - List, Set, Map
        // ✅ List
        final List<Integer> numbers = Arrays.asList(100, 200);
        numbers.add(300);
        // (a) 단일 값
        System.out.println(numbers.get(0));
        // (b) 향상된 for문 (for-each 문)
        for(int num : numbers) {
            System.out.println("num = " + num);
        }
        // (c) 일반 for문
        for(int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s %s", i, numbers.get(i));
        }

        // ✅ Map
        // (1) JDK 8까지
        Map<Integer, String> oldMap = new HashMap<>();
        oldMap.put(1, "MONDAY");
        oldMap.put(2, "TUESDAY");
        System.out.println("oldMap = " + oldMap);

        // (2) JDK 9부터
        Map<Integer, String> newMap = Map.of(1, "MONDAY", 2, "TUESDAY");
        System.out.println("newMap = " + newMap);

        // ☑️ 출력 방식
        for(int key : oldMap.keySet()) {
            System.out.println(key);
            System.out.println(oldMap.get(key));
        }

        for(Map.Entry<Integer, String> entry : newMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // 3. 컬렉션의 null 가능성, Java와 함께 사용할 때 주의할 점
        // ☑️ Java는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
        // ☑️ Java는 nullable 타입과 non-nullable 타입을 구분하지 않는다.
        //  => Kotlin 쪽의 컬렉션이 Java에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 한다.
        //  => Kotlin 쪽에서 Collections.unmodifableXXX()를 활용하면 변경 자체를 막을 수는 있다.
    }
}
