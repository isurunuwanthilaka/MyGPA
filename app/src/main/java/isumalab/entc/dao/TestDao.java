package isumalab.entc.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import isumalab.entc.entity.TestEntity;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface TestDao {

    @Query("select name from TestEntity")
    LiveData<List<String>> getAllTestName();

    @Query("DELETE FROM TestEntity")
    void deleteAll();


    @Insert(onConflict = REPLACE)
    void insertTestEntity(TestEntity testEntity);

    @Update(onConflict = REPLACE)
    void updateTestEntity(TestEntity testEntity);

}
