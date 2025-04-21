package com.study.lesson.basic;

public class Lesson_08_JAVA {
    public static void main(String[] args) {
        // 1. 함수 선언 문법
        int result1 = max(1, 2);
        System.out.println("result1 = " + result1);

        // 2. default parameter
        // => Java에서는 오버로딩을 사용해서 다수의 중복이 발생하는 파라미터의 기본값 설정이 가능
        // => 단, 필요한 만큼 오버로딩 메소드를 생성해야 함.

        // 3. named argument (parameter)

        // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
        String[] arr = new String[]{"A", "B", "C"};
        printAll(arr);

        printAll("A", "B", "C");
    }

    private static int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public static void repeat(String str, int num, boolean useNewLine) {
        for(int i = 1; i <= num; i++) {
            if(useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    // 오버로딩 함수 1
    private static void repeat(String str, int num) {
        repeat(str, num, true);
    }

    // 오버로딩 함수 2
    private static void repeat(String str) {
        repeat(str, 3, true);
    }

    public static void printAll(String... strings) {
        // 타입... : 가변인자
        for(String str : strings) {
            System.out.println(str);
        }
    }
}
