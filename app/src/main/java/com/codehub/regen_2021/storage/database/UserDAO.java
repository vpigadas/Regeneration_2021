package com.codehub.regen_2021.storage.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = REPLACE)
    public void save(UserEntity data);

    @Insert(onConflict = REPLACE)
    public void save(UserEntity... data);

//    @Insert
//    public void create(UserEntity data);
//
//    @Insert
//    public void create(UserEntity... data);

//    @Update
//    public void update(UserEntity data);

    @Delete
    public void delete(UserEntity data);

    @Delete
    public void delete(UserEntity[] data);

    @Query("SELECT * FROM User")
    @Nullable
    public List<UserEntity> read();

    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    public UserEntity first();

    @Query("SELECT * FROM User WHERE id = :id")
    @Nullable
    public List<UserEntity> read(int id);
}
