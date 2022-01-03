package com.codehub.regen_2021.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.codehub.regen_2021.R;
import com.codehub.regen_2021.storage.database.AsyncInsertDbTask;
import com.codehub.regen_2021.storage.database.AsyncReadDbTask;
import com.codehub.regen_2021.storage.database.DatabaseSchema;
import com.codehub.regen_2021.storage.database.UserEntity;

import java.util.List;

public class StorageActivity extends AppCompatActivity {

    @Nullable
    private DatabaseSchema database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        database = Room.databaseBuilder(StorageActivity.this, DatabaseSchema.class, "regeneration").build();


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (!preferences.contains("name")) {
            editor.putString("name", "Vassilis");
        }

        editor.putInt("age", 100);
        editor.apply();
//        editor.commit();

        Button button = findViewById(R.id.storage_btn_insert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity user = new UserEntity("vassilis", 100, "user", "A");
                new AsyncInsertDbTask(database, new AsyncInsertDbTask.Listener() {
                    @Override
                    public void onResult(boolean result) {
                        Toast.makeText(StorageActivity.this, "Data inserted!!! " + result, Toast.LENGTH_SHORT).show();
                    }
                }).execute(user);
            }
        });

        Button buttonRead = findViewById(R.id.storage_btn_read);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncReadDbTask(database, new AsyncReadDbTask.Listener() {
                    @Override
                    public void onResult(List<UserEntity> result) {
                        TextView textView = findViewById(R.id.storage_txt_counter);
                        textView.setText(String.valueOf(result.size()));
                    }
                }).execute();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        SharedPreferences preferences = getSharedPreferences("project_future", MODE_PRIVATE);
        SharedPreferences userPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
    }

    @Override
    protected void onStop() {

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (!preferences.contains("name")) {
            editor.putString("name", "Vassilis");
        }

        editor.putInt("age", 100);
        editor.apply();

        super.onStop();
    }
}