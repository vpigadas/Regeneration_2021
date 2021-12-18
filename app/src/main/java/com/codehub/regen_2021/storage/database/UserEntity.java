package com.codehub.regen_2021.storage.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserEntity {

    @PrimaryKey(autoGenerate = true) private int id;
    @ColumnInfo(name = "name") private String name;
    @ColumnInfo(name = "user_age") private int age;
    @ColumnInfo(name = "user_type") private String type;
    @ColumnInfo(name = "skills") private String skills;

    public UserEntity() {
    }

    public UserEntity(String name, int age, String type, String skills) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
