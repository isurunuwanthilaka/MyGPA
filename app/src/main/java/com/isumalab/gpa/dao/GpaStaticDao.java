package com.isumalab.gpa.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.isumalab.gpa.entity.GpaEntity;
import com.isumalab.gpa.entity.ModuleEntity;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GpaStaticDao {

    @Query("select * from module_table where gpa=1")
    List<ModuleEntity> getAllModuleEntity();

    @Query("select * from module_table where gpa=1 and semester_no=:semNo")
    List<ModuleEntity> getSemModuleEntity(int semNo);

    @Insert(onConflict = REPLACE)
    void insert(GpaEntity gpaEntity);

    @Update(onConflict = REPLACE)
    void update(GpaEntity gpaEntity);

    @Delete
    void delete(GpaEntity gpaEntity);

}
