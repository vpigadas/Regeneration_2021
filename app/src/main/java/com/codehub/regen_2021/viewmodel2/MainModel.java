package com.codehub.regen_2021.viewmodel2;

public class MainModel {
    private int counter1 = 0;
    private int counter2 = 0;

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public void setCounter2(int counter2) {
        this.counter2 = counter2;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "counter1=" + counter1 +
                ", counter2=" + counter2 +
                '}';
    }
}
