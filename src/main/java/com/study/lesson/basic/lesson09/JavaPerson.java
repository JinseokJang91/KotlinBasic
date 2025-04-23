package com.study.lesson.basic.lesson09;

public class JavaPerson {
    private final String name;
    // getter 없는 경우 초기화가 되지 않은 상태이므로 에러 발생

    private int age;

    public JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;

        // ✅ 검증 로직 (age)
        if(this.age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다", this.age));
        }
    }

    // ✅ 새로운 생성자 - 오버로딩
    public JavaPerson(String name) {
        this(name, 1);
    }

    // ✅ 성인 검증 함수
    public boolean isAdult() {
        return this.age >= 20;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString()
    @Override
    public String toString() {
        return "JavaPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
