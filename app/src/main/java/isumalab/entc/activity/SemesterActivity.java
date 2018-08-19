package isumalab.entc.activity;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;
import isumalab.entc.entity.TestEntity;
import isumalab.entc.utils.AppDatabase;
import isumalab.entc.utils.DatabaseInitializer;
import isumalab.entc.utils.Repository;

public class SemesterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AppDatabase mDb;
    private TextView textView;
    private Repository repository;
    private LiveData<List<String>> mAllTests;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        //adding toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        textView = (TextView) findViewById(R.id.textdb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //create database here for the first time and use it for later use
        //normally it should be used once
//        mDb = AppDatabase.getDatabase(getApplicationContext());


        //here we populate our db with testing data
        //data in the database initializer class

//        populateDb();
//
//        fetchData();
        repository = new Repository(getApplicationContext());

        Date currentTime = Calendar.getInstance().getTime();
        TestEntity testEntity = new TestEntity();
        testEntity.setName("Log : "+currentTime.toString());
        repository.insert(testEntity);

        LiveData<List<String>> ln = repository.getAllTestName();
        try {
            String s = "";
            for(int i=0 ; i<ln.getValue().size();i++){
                s+=ln.getValue().get(i);
            }
            textView.setText(s);
        }catch (Exception e){
            textView.setText(e.getMessage());
        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

//    private void populateDb() {
//        DatabaseInitializer.populateSync(mDb);
//    }
//
//    private void fetchData() {
//        // Note: this kind of logic should not be in an activity.
////        StringBuilder sb = new StringBuilder();
//        String moduleNameById = String.valueOf(mDb.testModele().getTestName().size());
//        textView.setText(moduleNameById);
//    }


}
