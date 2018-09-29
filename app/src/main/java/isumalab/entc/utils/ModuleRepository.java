package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import isumalab.entc.dao.GpaDao;
import isumalab.entc.dao.GpaStaticDao;
import isumalab.entc.dao.ModuleDao;
import isumalab.entc.entity.GpaEntity;
import isumalab.entc.entity.ModuleEntity;

public class ModuleRepository {
    private ModuleDao mModuleDao;
    private GpaDao mGpaDao;

    private LiveData<List<ModuleEntity>> mSemOneModules;
    private LiveData<List<ModuleEntity>> mSemEightModules;
    private LiveData<List<ModuleEntity>> mSemTwoModules;
    private LiveData<List<ModuleEntity>> mSemThreeModules;
    private LiveData<List<ModuleEntity>> mSemFourModules;
    private LiveData<List<ModuleEntity>> mSemFiveModules;
    private LiveData<List<ModuleEntity>> mSemSixModules;
    private LiveData<List<ModuleEntity>> mSemSevenModules;
    private LiveData<List<ModuleEntity>> mAllModules;

    private LiveData<Double> mOverallGpaEntity;
    private LiveData<Double> mGpaSem1;
    private LiveData<Double> mGpaSem2;
    private LiveData<Double> mGpaSem3;
    private LiveData<Double> mGpaSem4;
    private LiveData<Double> mGpaSem5;
    private LiveData<Double> mGpaSem6;
    private LiveData<Double> mGpaSem7;
    private LiveData<Double> mGpaSem8;


    public ModuleRepository(){}

    public ModuleRepository(Application application) {
        ModuleRoomDatabase db = ModuleRoomDatabase.getDatabase(application);
        mModuleDao = db.moduleDao();
        mGpaDao = db.gpaDao();

        mSemOneModules = mModuleDao.getSemOneModules();
        mSemTwoModules = mModuleDao.getSemTwoModules();
        mSemThreeModules = mModuleDao.getSemThreeModules();
        mSemFourModules = mModuleDao.getSemFourModules();
        mSemFiveModules = mModuleDao.getSemFiveModules();
        mSemSixModules = mModuleDao.getSemSixModules();
        mSemSevenModules = mModuleDao.getSemSevenModules();
        mSemEightModules = mModuleDao.getSemEightModules();
        mAllModules = mModuleDao.getAllModules();

        mOverallGpaEntity = mGpaDao.getGpaEntity(9);//9 for overall gpa
        mGpaSem1 = mGpaDao.getGpaEntity(1);
        mGpaSem2 = mGpaDao.getGpaEntity(2);
        mGpaSem3 = mGpaDao.getGpaEntity(3);
        mGpaSem4 = mGpaDao.getGpaEntity(4);
        mGpaSem5 = mGpaDao.getGpaEntity(5);
        mGpaSem6 = mGpaDao.getGpaEntity(6);
        mGpaSem7 = mGpaDao.getGpaEntity(7);
        mGpaSem8 = mGpaDao.getGpaEntity(8);

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
    LiveData<List<ModuleEntity>> getSemEightModules() {return mSemEightModules;}
    LiveData<List<ModuleEntity>> getAllModules() {return mAllModules;}
    LiveData<Double> getOverallGpaEntity(){return mOverallGpaEntity;}
    LiveData<Double> getGpaSem1(){return mGpaSem1;}
    LiveData<Double> getGpaSem2(){return mGpaSem2;}
    LiveData<Double> getGpaSem3(){return mGpaSem3;}
    LiveData<Double> getGpaSem4(){return mGpaSem4;}
    LiveData<Double> getGpaSem5(){return mGpaSem5;}
    LiveData<Double> getGpaSem6(){return mGpaSem6;}
    LiveData<Double> getGpaSem7(){return mGpaSem7;}
    LiveData<Double> getGpaSem8(){return mGpaSem8;}

    public List<ModuleEntity> getAllModuleEntity(){ return mModuleDao.getAllModuleEntity();}

    public void insert (GpaEntity gpaEntity) {
        new ModuleRepository.insertAsyncTaskGpa(mGpaDao).execute(gpaEntity);
    }

    public void update (GpaEntity gpaEntity) {
        new ModuleRepository.updateAsyncTaskGpa(mGpaDao).execute(gpaEntity);
    }

    public void delete (GpaEntity gpaEntity) {
        new ModuleRepository.deleteAsyncTaskGpa(mGpaDao).execute(gpaEntity);
    }

    public void insert (ModuleEntity moduleEntity) {
        new ModuleRepository.insertAsyncTask(mModuleDao).execute(moduleEntity);
    }

    public void update (ModuleEntity moduleEntity) {
        new ModuleRepository.updateAsyncTask(mModuleDao).execute(moduleEntity);
    }

    public void delete (ModuleEntity moduleEntity) {
        new ModuleRepository.deleteAsyncTask(mModuleDao).execute(moduleEntity);
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

    private static class deleteAsyncTask extends AsyncTask<ModuleEntity, Void, Void> {

        private ModuleDao mAsyncTaskDao;

        deleteAsyncTask(ModuleDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ModuleEntity... params) {
            mAsyncTaskDao.deleteModuleEntity(params[0]);
            return null;
        }
    }

    private static class insertAsyncTaskGpa extends AsyncTask<GpaEntity, Void, Void> {

        private GpaDao mAsyncTaskDao;

        insertAsyncTaskGpa(GpaDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GpaEntity... params) {
            mAsyncTaskDao.insertGpaEntity(params[0]);
            return null;
        }
    }

    private static class updateAsyncTaskGpa extends AsyncTask<GpaEntity, Void, Void> {

        private GpaDao mAsyncTaskDao;

        updateAsyncTaskGpa(GpaDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GpaEntity... params) {
            mAsyncTaskDao.updateGpaEntity(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTaskGpa extends AsyncTask<GpaEntity, Void, Void> {

        private GpaDao mAsyncTaskDao;

        deleteAsyncTaskGpa(GpaDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GpaEntity... params) {
            mAsyncTaskDao.deleteGpaEntity(params[0]);
            return null;
        }
    }
}