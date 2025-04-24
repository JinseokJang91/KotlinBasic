package com.study.lesson.basic.lesson12;

public class JavaSingleton {
    // ☑️ 싱글톤 : 단 하나의 인스턴스만을 갖는 클래스
    private static final JavaSingleton INSTANCE = new JavaSingleton();

    private JavaSingleton() {}

    public static JavaSingleton getInstance() {
        return INSTANCE;
    }
}
