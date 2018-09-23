package isumalab.entc.utils;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import isumalab.entc.dao.ModuleDao;
import isumalab.entc.entity.ModuleEntity;

@Database(entities = {ModuleEntity.class}, version = 1)
public abstract class ModuleRoomDatabase extends RoomDatabase {

    public abstract ModuleDao moduleDao();

    private static ModuleRoomDatabase INSTANCE;

    static ModuleRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ModuleRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ModuleRoomDatabase.class, "module_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };
}
