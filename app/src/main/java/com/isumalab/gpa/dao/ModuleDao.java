package com.isumalab.gpa.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.isumalab.gpa.entity.ModuleEntity;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface ModuleDao {

    @Query("select * from module_table where semester_no=1 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemOneModules();

    @Query("select * from module_table where semester_no=2 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemTwoModules();

    @Query("select * from module_table where semester_no=3 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemThreeModules();

    @Query("select * from module_table where semester_no=4 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemFourModules();

    @Query("select * from module_table where semester_no=5 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemFiveModules();

    @Query("select * from module_table where semester_no=6 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemSixModules();

    @Query("select * from module_table where semester_no=7 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemSevenModules();

    @Query("select * from module_table where semester_no=8 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getSemEightModules();

    @Query("select * from module_table where gpa=1 ORDER BY id ASC")
    LiveData<List<ModuleEntity>> getAllModules();

    @Query("select * from module_table")
    List<ModuleEntity> getAllModuleEntity();

    @Query("select * from module_table where module_code LIKE :moduleCode")
    ModuleEntity getModuleByModuleCode(String moduleCode);

    @Query("delete from module_table where module_code LIKE :moduleCode")
    void deleteModuleByModuleCode(String moduleCode);

    @Insert(onConflict = REPLACE)
    void insertModuleEntity(ModuleEntity moduleEntity);

    @Update(onConflict = REPLACE)
    void updateModuleEntity(ModuleEntity moduleEntity);

    @Delete
    void deleteModuleEntity(ModuleEntity moduleEntity);

}
