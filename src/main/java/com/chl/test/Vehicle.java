package com.chl.test;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 11:27
 **/
public class Vehicle {
    private int speed;

    public void move() {
        System.out.println("i’m moving");
    }

    public void setSpeed(int speed) {
        System.out.println("now i’m running with " + speed + " per hour");
    }

    public void speedUp() {
        this.setSpeed(100);
    }

    public void speedDown() {
        this.setSpeed(20);
    }

    public static void main(String[] dsa) {
        Vehicle v = new Vehicle();
        v.speed = 50;
        System.out.println("the initial speed is " + v.speed);
        v.move();
        v.speedUp();
        v.speedDown();
    }
}
