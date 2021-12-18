package com.codehub.regen_2021.storage.database;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class AsyncReadDbTask extends AsyncTask<Void, Void, List<UserEntity>> {
    public interface Listener {
        public void onResult(List<UserEntity> result);
    }

    private DatabaseSchema databaseSchema;
    private AsyncReadDbTask.Listener listener;

    public AsyncReadDbTask(DatabaseSchema databaseSchema, Listener listener) {
        this.databaseSchema = databaseSchema;
        this.listener = listener;
    }

    @Override
    protected List<UserEntity> doInBackground(Void... voids) {
        try {
            return databaseSchema.getUserDao().read();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    @Override
    protected void onPostExecute(List<UserEntity> userEntities) {
        super.onPostExecute(userEntities);
        listener.onResult(userEntities);

    }
}
