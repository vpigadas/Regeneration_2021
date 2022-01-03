package com.codehub.regen_2021.viewmodel2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MainViewModel extends AndroidViewModel {
    private static final String ARG_PREFERENCE_NAME = "counters";
    private static final String ARG_PREFERENCE_COUNTER_1 = "counter1";
    private static final String ARG_PREFERENCE_COUNTER_2 = "counter2";
    public static final String ARG_CANCEL = "CANCEL";
    public static final String ARG_SAVE = "SAVE";

    private MainRepository repository;
    private MutableLiveData<String> streamMessages = new MutableLiveData<>();
    private MutableLiveData<Integer> streamVote1 = new MutableLiveData<>();
    private MutableLiveData<Integer> streamVote2 = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new MainRepository();

    }

    public void observeMessages(LifecycleOwner owner, Observer<String> observer) {
        streamMessages.observe(owner, observer);
    }

    public void observeVote1(LifecycleOwner owner, Observer<Integer> observer) {
        streamVote1.observe(owner, observer);
    }

    public void observeVote2(LifecycleOwner owner, Observer<Integer> observer) {
        streamVote2.observe(owner, observer);
    }

    public void okClickOk() {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(ARG_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putInt(ARG_PREFERENCE_COUNTER_1, repository.getCounter1Value())
                .putInt(ARG_PREFERENCE_COUNTER_2, repository.getCounter2Value())
                .apply();
        streamMessages.postValue(ARG_SAVE);
    }

    public void onClickCancel() {
        streamMessages.postValue(ARG_CANCEL);
    }

    public void onClickIncrease(Integer position) {
        if (position == 1) {
            repository.increaseCounter1();
            streamVote1.postValue(repository.getCounter1Value());
        } else if (position == 2) {
            repository.increaseCounter2();
            streamVote2.postValue(repository.getCounter2Value());
        }
    }
}
