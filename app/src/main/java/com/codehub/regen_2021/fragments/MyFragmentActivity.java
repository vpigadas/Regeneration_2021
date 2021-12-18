package com.codehub.regen_2021.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.codehub.regen_2021.R;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();

        BlankFragment fragment = new BlankFragment();
        Bundle parameter = new Bundle();
        parameter.putString("name", getString(R.string.app_name));
        fragment.setArguments(parameter);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment, "BlankFragment");
        transaction.commit();
    }
}