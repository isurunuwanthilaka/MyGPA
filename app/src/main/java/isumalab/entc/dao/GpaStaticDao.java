package isumalab.entc.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import isumalab.entc.entity.GpaEntity;
import isumalab.entc.entity.ModuleEntity;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

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
