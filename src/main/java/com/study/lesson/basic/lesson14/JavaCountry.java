package com.study.lesson.basic.lesson14;

public enum JavaCountry {
    // ☑️ 추카적인 클래스를 상속 받을 수 없다.
    // ☑️ 인터페이스는 구현 가능하다.
    // ☑️ 각 코드는 싱글톤이다.

    KOREA("KO"),
    AMERICA("US"),

    ADDITIONAL("test") // ☑️ enum 추가 등록해도 호출 함수에서 에러 발생하지 않음
    ;

    private final String code;

    JavaCountry(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
