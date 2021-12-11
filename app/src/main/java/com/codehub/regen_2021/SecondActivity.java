package com.codehub.regen_2021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getBaseContext().getResources().getString(R.string.app_name);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        String name = getIntent().getExtras().getString("name");
        Log.d("APP", name);

        Button button = findViewById(R.id.second_btn_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent.putExtra("name", "Orfeas");

                setResult(Activity.RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        String name = getIntent().getExtras().getString("name");
        Log.d("APP", name);
    }

    private boolean secondTap = false;

    @Override
    public void onBackPressed() {
        Toast.makeText(SecondActivity.this, "You pressed the back button!!!", Toast.LENGTH_SHORT).show();

        if (secondTap == true) {
            super.onBackPressed();
        } else {
            secondTap = true;
        }
    }
}