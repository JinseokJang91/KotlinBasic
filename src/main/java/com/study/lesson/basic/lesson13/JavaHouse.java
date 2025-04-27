package com.study.lesson.basic.lesson13;

public class JavaHouse {
    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        public String getAddress() {
            // LivingRoom static class로 사용시 getAddress() 사용 불가
            return JavaHouse.this.address;
        }
    }
}
