package com.codehub.regen_2021;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_constraint;
    }

    @Override
    public void useUIElements() {
        ImageView imageView = findViewById(R.id.login_linear_back_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        TextView textView = findViewById(R.id.login_linear_title);
        textView.setText(getString(R.string.app_name));

        Button btnLogin = findViewById(R.id.login_linear_login);
        Button btnForgot = findViewById(R.id.login_linear_forgot);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }


//                Snackbar.make(view, "Button clicked!!!", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "Vassilis");

                startActivityForResult(intent, 1000);
            }
        });
        btnLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Snackbar.make(view, "Button clicked!!!", Snackbar.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Button Long clicked!!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("APP", "forgot button clicked!!!");
            }
        });
    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "You pressed the back button!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (data.getExtras() != null) {
                String name = data.getExtras().getString("name");
                Log.d("APP", name);
            }
        }
    }
}