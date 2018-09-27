package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import isumalab.entc.dao.ModuleDao;
import isumalab.entc.entity.ModuleEntity;

public class ModuleRepository {
    private ModuleDao mModuleDao;
    private LiveData<List<ModuleEntity>> mSemOneModules;
    private LiveData<List<ModuleEntity>> mSemEightModules;
    private LiveData<List<ModuleEntity>> mSemTwoModules;
    private LiveData<List<ModuleEntity>> mSemThreeModules;
    private LiveData<List<ModuleEntity>> mSemFourModules;
    private LiveData<List<ModuleEntity>> mSemFiveModules;
    private LiveData<List<ModuleEntity>> mSemSixModules;
    private LiveData<List<ModuleEntity>> mSemSevenModules;

    public ModuleRepository(){}

    public ModuleRepository(Application application) {
        ModuleRoomDatabase db = ModuleRoomDatabase.getDatabase(application);
        mModuleDao = db.moduleDao();
        mSemOneModules = mModuleDao.getSemOneModules();
        mSemTwoModules = mModuleDao.getSemTwoModules();
        mSemThreeModules = mModuleDao.getSemThreeModules();
        mSemFourModules = mModuleDao.getSemFourModules();
        mSemFiveModules = mModuleDao.getSemFiveModules();
        mSemSixModules = mModuleDao.getSemSixModules();
        mSemSevenModules = mModuleDao.getSemSevenModules();
        mSemEightModules = mModuleDao.getSemEightModules();
    }

    LiveData<List<ModuleEntity>> getSemOneModules() {
        return mSemOneModules;
    }
    LiveData<List<ModuleEntity>> getSemTwoModules() {
        return mSemTwoModules;
    }
    LiveData<List<ModuleEntity>> getSemThreeModules() {
        return mSemThreeModules;
    }
    LiveData<List<ModuleEntity>> getSemFourModules() {
        return mSemFourModules;
    }
    LiveData<List<ModuleEntity>> getSemFiveModules() {
        return mSemFiveModules;
    }
    LiveData<List<ModuleEntity>> getSemSixModules() {
        return mSemSixModules;
    }
    LiveData<List<ModuleEntity>> getSemSevenModules() {
        return mSemSevenModules;
    }
    LiveData<List<ModuleEntity>> getSemEightModules() {
        return mSemEightModules;
    }

    public void insert (ModuleEntity moduleEntity) {
        new ModuleRepository.insertAsyncTask(mModuleDao).execute(moduleEntity);
    }

    public void update (ModuleEntity moduleEntity) {
        new ModuleRepository.updateAsyncTask(mModuleDao).execute(moduleEntity);
    }



    private static class insertAsyncTask extends AsyncTask<ModuleEntity, Void, Void> {

        private ModuleDao mAsyncTaskDao;

        insertAsyncTask(ModuleDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ModuleEntity... params) {
            mAsyncTaskDao.insertModuleEntity(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<ModuleEntity, Void, Void> {

        private ModuleDao mAsyncTaskDao;

        updateAsyncTask(ModuleDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ModuleEntity... params) {
            mAsyncTaskDao.updateModuleEntity(params[0]);
            return null;
        }
    }
}