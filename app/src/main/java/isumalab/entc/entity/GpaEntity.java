package isumalab.entc.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
