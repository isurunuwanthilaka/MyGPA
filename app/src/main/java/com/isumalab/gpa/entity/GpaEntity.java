package com.isumalab.gpa.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "gpa_table")
public class GpaEntity {

    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public double getGpa() {
        return gpa;
    }

    public void setGpa(@NonNull double gpa) {
        this.gpa = gpa;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @NonNull
    private double gpa;

    private String info;
}
