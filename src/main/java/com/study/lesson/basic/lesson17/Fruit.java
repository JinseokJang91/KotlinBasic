package com.study.lesson.basic.lesson17;

public class Fruit {
    private final String name;
    private final int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isApple() {
        return "사과".equals(this.name);
    }
}
