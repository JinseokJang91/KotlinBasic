package com.study.lesson.basic;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lesson_07_JAVA {
    public static void main(String[] args) {
        // 1. try-catch-finally 구문
        //parseIntOrThrow("123A");
        //parseIntOrThrowV2("456A");

        // 2. Checked Exception 과 Unchecked Exception
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("IOException !!!");
        }


        // 3. try with resources (JDK 7 추가)
        try {
            readFile2("./a.txt");
        } catch (IOException e) {
            System.out.println("IOException !!!");
        }
    }

    private static int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }

    private static Integer parseIntOrThrowV2(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void readFile() throws IOException {
        // IOException : Checked Exception
        // => Checked Exception 은 반드시 표시

        File currentFile = new File("."); // . 은 현재위치
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
    }

    public static void readFile2(String path) throws IOException {
        // try with resources 구문 사용
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }
}
