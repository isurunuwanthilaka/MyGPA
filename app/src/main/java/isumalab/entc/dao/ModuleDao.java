package isumalab.entc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface ModuleDao {

    @Query("select module_name from moduledb where id = 1")
    String getModuleNameById(int id);

}
