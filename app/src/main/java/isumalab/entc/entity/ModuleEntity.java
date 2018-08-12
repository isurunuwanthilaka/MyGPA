package isumalab.entc.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ModuleEntity {

    @PrimaryKey
    @NonNull
    private int id;

    @NonNull
    private int semester_no;

    @NonNull
    private String module_name;

    @NonNull
    private String module_code;

    @NonNull
    private boolean is_gpa;

    @NonNull
    private int credit;

    @NonNull
    private boolean is_active;

    private int score;

}
