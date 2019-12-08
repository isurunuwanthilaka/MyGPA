package com.isumalab.gpa.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.isumalab.gpa.entity.GpaEntity;
import static androidx.room.OnConflictStrategy.REPLACE;

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
