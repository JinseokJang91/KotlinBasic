package com.study.lesson.basic.lesson10;

public final class JavaPenguin extends JavaAnimal implements JavaFlyable, JavaSwimable{
    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("펭귄이 파닥파닥 거립니다.");
    }

    @Override
    public int getLegCount() {
        return super.getLegCount() + this.wingCount;
    }

    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }

    @Override
    public void fly() {
        // 추상 메소드
        System.out.println("[JAVA] fly 추상 메소드");
    }
}
