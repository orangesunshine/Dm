package com.orange.viewbinding;

import java.util.function.Supplier;

public class Car {
    public String name;
    public int number;

    public Car() {
    }

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaird " + this.toString());
    }
}
