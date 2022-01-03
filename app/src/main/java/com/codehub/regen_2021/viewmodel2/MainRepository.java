package com.codehub.regen_2021.viewmodel2;

public class MainRepository {
    private MainModel mainModel;

    public MainRepository() {
        mainModel = new MainModel();
    }

    public void increaseCounter1() {
        mainModel.setCounter1(mainModel.getCounter1() + 1);
    }

    public void increaseCounter2() {
        mainModel.setCounter2(mainModel.getCounter2() + 1);
    }

    public int getCounter1Value() {
        return mainModel.getCounter1();
    }

    public int getCounter2Value() {
        return mainModel.getCounter2();
    }
}
