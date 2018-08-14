package isumalab.entc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import isumalab.entc.entity.ModuleEntity;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface ModuleDao {

    @Query("select module_name from ModuleEntity where id = 1")
    String getModuleNameById();

    @Query("DELETE FROM ModuleEntity")
    void deleteAll();


    @Insert(onConflict = REPLACE)
    void insertModuleEntity(ModuleEntity moduleEntity);

    @Update(onConflict = REPLACE)
    void updateModuleEntity(ModuleEntity moduleEntity);

}
