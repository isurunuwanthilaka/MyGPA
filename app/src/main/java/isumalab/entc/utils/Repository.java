package isumalab.entc.utils;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import isumalab.entc.dao.TestDao;
import isumalab.entc.entity.TestEntity;

public class Repository {

    private TestDao mTestDao;
    private LiveData<List<String>> mAllTests;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public Repository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        mTestDao = db.testModele();
        mAllTests = mTestDao.getAllTestName();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<String>> getAllTestName() {
        return mAllTests;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insert (TestEntity testEntity) {
        new insertAsyncTask(mTestDao).execute(testEntity);
    }

    private static class insertAsyncTask extends AsyncTask<TestEntity, Void, Void> {

        private TestDao mAsyncTaskDao;

        insertAsyncTask(TestDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TestEntity... params) {
            mAsyncTaskDao.insertTestEntity(params[0]);
            return null;
        }
    }
}