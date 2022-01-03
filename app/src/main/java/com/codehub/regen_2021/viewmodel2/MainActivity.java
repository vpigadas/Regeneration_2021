package com.codehub.regen_2021.viewmodel2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codehub.regen_2021.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    @Nullable
    private TextView textVote2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        textVote2 = findViewById(R.id.txt_vote_two);

        Button btnVote1 = findViewById(R.id.btn_vote_one);
        btnVote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onClickIncrease(1);
            }
        });
        Button btnVote2 = findViewById(R.id.btn_vote_two);
        btnVote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onClickIncrease(2);
            }
        });

        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.okClickOk();
            }
        });
        Button btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onClickCancel();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        viewModel.observeMessages(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals(MainViewModel.ARG_CANCEL)) {
                    finish();
                } else if(s.equals(MainViewModel.ARG_SAVE)) {
                    Toast.makeText(MainActivity.this, "Counters saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.observeVote1(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textVote1 = findViewById(R.id.txt_vote_one);
                textVote1.setText(String.valueOf(integer));
            }
        });
        viewModel.observeVote2(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (textVote2 != null) {
                    textVote2.setText(String.valueOf(integer));
                }

//                if (textVote2 == null) {
//                    return;
//                }
//                textVote2.setText(String.valueOf(integer));
            }
        });
    }
}