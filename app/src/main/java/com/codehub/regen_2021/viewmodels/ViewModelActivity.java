package com.codehub.regen_2021.viewmodels;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.codehub.regen_2021.R;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.printResult();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, new ViewModelFragment(), "ViewModelFragment");
        transaction.commit();

        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.frameLayout2, new ViewModel2Fragment(), "ViewModel2Fragment");
        transaction2.commit();

        Button button = findViewById(R.id.btn_counter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increaseCounter();
            }
        });

        Button button2 = findViewById(R.id.btn_counter2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.decreaseCounter();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.printResult();
        viewModel.setName("Markos");
        viewModel.liveData.setValue("Markos-Live");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.removeObserver(this);
    }
}