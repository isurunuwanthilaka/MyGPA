package isumalab.entc.utils;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import isumalab.entc.activity.NewModuleActivity;
import isumalab.entc.dao.GpaDao;
import isumalab.entc.dao.GpaStaticDao;
import isumalab.entc.dao.ModuleDao;
import isumalab.entc.entity.GpaEntity;
import isumalab.entc.entity.ModuleEntity;

@Database(entities = {ModuleEntity.class,GpaEntity.class}, version = 1,exportSchema = false)
public abstract class ModuleRoomDatabase extends RoomDatabase {

    public abstract ModuleDao moduleDao();
    public abstract GpaDao gpaDao();
    public abstract GpaStaticDao gpaStaticDao();
    private static ModuleRoomDatabase INSTANCE;

    public static ModuleRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ModuleRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ModuleRoomDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
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
//            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ModuleDao mDao;

        PopulateDbAsync(ModuleRoomDatabase db) {
            mDao = db.moduleDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
//            mDao.deleteAll();

            ModuleEntity moduleEntity = new ModuleEntity();
            moduleEntity.setModule_name("Electronics");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(1);
            moduleEntity.setModule_code("en0001");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(2);
            moduleEntity.setModule_code("en0002");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals3");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(3);
            moduleEntity.setModule_code("en0003");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals4");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(4);
            moduleEntity.setModule_code("en0004");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals5");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(5);
            moduleEntity.setModule_code("en0005");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals6");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(6);
            moduleEntity.setModule_code("en0006");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals7");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(7);
            moduleEntity.setModule_code("en0007");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            moduleEntity.setModule_name("Signals8");
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(8);
            moduleEntity.setModule_code("en0008");
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mDao.insertModuleEntity(moduleEntity);

            return null;
        }
    }
}
