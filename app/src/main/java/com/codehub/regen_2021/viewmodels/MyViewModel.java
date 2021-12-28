package com.codehub.regen_2021.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    public MutableLiveData<String> liveData = new MutableLiveData<>();
    private MutableLiveData<Integer> liveData2 = new MutableLiveData<>();

    public void observeLiveData2(LifecycleOwner owner, Observer<Integer> observer) {
        liveData2.observe(owner, observer);
    }

    public void removeObserver(LifecycleOwner owner) {
        liveData2.removeObservers(owner);
        liveData.removeObservers(owner);
    }

    private String name = "Vassilis";
    private int counter = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String printResult() {
        return name;
    }

    public void increaseCounter() {
        counter++;
        liveData.setValue(String.valueOf(counter));
        liveData2.setValue(counter);
        liveData2.postValue(counter);
    }

    public void decreaseCounter() {
        counter--;
        liveData2.setValue(counter);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}


