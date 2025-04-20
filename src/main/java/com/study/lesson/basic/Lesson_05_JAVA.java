package com.study.lesson.basic;

public class Lesson_05_JAVA {
    public static void main(String[] args) {
        // 1. if문
        // validateScoreIsNotNegative(-10); // ⚠️ 예외 발생

        // 2. Expression과 Statement
        // ☑️ if-else는 Java에서는 Statement, Kotlin에서는 Expression
        // Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
        // Expression : 하나의 값으로 도출되는 문장
        String result1 = getPassOrFail(50);
        System.out.println("result1 = " + result1);

        // 예시
        int score = 30 + 40; // Expression이면서 Statement => 70이라는 하나의 결과 도출

        // ⚠️ if문을 하나의 값으로 취급하지 않으므로 에러 발생
//        String grade1 = if(score >= 50) {
//            "PASS";
//        } else {
//            "FAIL";
//        }
        // => Java에서는 3항 연산자로 대체할 수 있음
        String grade2 = score >= 50 ? "PASS" : "FAIL"; // Expression이면서 Statement => 3항 연산자는 하나의 값으로 취급
        System.out.println("grade2 = " + grade2);

        // ☑️ if-else if-else 문도 if-else와 동일
        String result2 = getGrade(75);
        System.out.println("result2 = " + result2);

        // ☑️ 조건에 범위를 사용하는 경우, Java에서는 다음과 같이 사용해야 한다.
        if(0 <= score && score <= 100) {
            System.out.println("점수는 0점과 100점 사이이다.");
        }

        // 3. switch와 when
    }

    private static void validateScoreIsNotNegative(int score) {
        if(score < 0) {
            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다.", score));
        }
    }

    private static String getPassOrFail(int score) {
        if(score >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    private static String getGrade(int score) {
        if(score >= 90) {
            return "A";
        } else if(score >= 80) {
            return "B";
        } else if(score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    private String getGradeWithSwitch(int score ) {
        switch (score / 10) {
            case 9 -> {
                return "A";
            }
            case 8 -> {
                return "B";
            }
            case 7 -> {
                return "C";
            }
            default -> {
                return "D";
            }
        }
    }

    private boolean startsWithA(Object obj) {
        if(obj instanceof String) {
            return ((String) obj).startsWith("A");
        } else {
            return false;
        }
    }

    private void judgeNumber(int number) {
//        if(number == 1 || number == 0 || number == -1) {
//            System.out.println("1, 0, -1 중 하나입니다.");
//        } else {
//            System.out.println("1, 0. -1 이 아닙니다.");
//        }

        switch (number) {
            case 1, 0, -1 -> {
                System.out.println("1, 0, -1 중 하나입니다.");
            }
            default -> {
                System.out.println("1, 0. -1 이 아닙니다.");
            }
        }
    }

    private void judgeNumber2(int number) {
        if(number == 0) {
            System.out.println("주어진 숫자는 0입니다.");
            return;
        }

        if(number % 2 == 0) {
            System.out.println("주어진 숫자는 짝수입니다.");
            return;
        }

        System.out.println("주어진 숫자는 홀수입니다.");
    }
}
