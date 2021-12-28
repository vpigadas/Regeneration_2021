package com.codehub.regen_2021.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.codehub.regen_2021.R;
import com.codehub.regen_2021.fragments.sheet.MyBottomSheetFragment;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button button = findViewById(R.id.btn_bottomSheet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBottomSheetFragment sheetFragment = new MyBottomSheetFragment();
                sheetFragment.show(getSupportFragmentManager(), "MyBottomSheetFragment");
            }
        });
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