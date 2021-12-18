package com.codehub.regen_2021.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseSchema extends RoomDatabase {
    public abstract UserDAO getUserDao();
}
