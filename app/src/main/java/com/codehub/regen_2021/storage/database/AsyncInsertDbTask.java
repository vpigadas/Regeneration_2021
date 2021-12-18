package com.codehub.regen_2021.storage.database;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

public class AsyncInsertDbTask extends AsyncTask<UserEntity, Void, Boolean> {
    public interface Listener {
        public void onResult(boolean result);
    }

    private DatabaseSchema databaseSchema;
    private Listener listener;

    public AsyncInsertDbTask(@NonNull DatabaseSchema databaseSchema, Listener listener) {
        this.databaseSchema = databaseSchema;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Boolean doInBackground(UserEntity... userEntities) {
//        databaseSchema.getUserDao().save(userEntities);

        try {
            for (UserEntity user : userEntities) {
                databaseSchema.getUserDao().save(user);
            }
        } catch (Exception exception) {
            return false;
        }


        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.onResult(aBoolean);
    }
}
