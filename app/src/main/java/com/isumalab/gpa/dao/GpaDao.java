package com.isumalab.gpa.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.isumalab.gpa.entity.GpaEntity;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface GpaDao {

    @Query("select gpa from gpa_table where id= :id")
    LiveData<Double> getGpaEntity(int id);

    @Insert(onConflict = REPLACE)
    void insertGpaEntity(GpaEntity gpaEntity);

    @Update(onConflict = REPLACE)
    void updateGpaEntity(GpaEntity gpaEntity);

    @Delete
    void deleteGpaEntity(GpaEntity gpaEntity);

}
