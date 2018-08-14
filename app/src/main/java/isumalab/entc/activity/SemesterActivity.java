package isumalab.entc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;
import isumalab.entc.utils.AppDatabase;
import isumalab.entc.utils.DatabaseInitializer;

public class SemesterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AppDatabase mDb;
    private TextView textView;


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
        //normaly it should be used once
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());


        //here we populate our db with testing data
        //data in the database initializer class

        populateDb();

        fetchData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        String moduleNameById = mDb.moduleModel().getModuleNameById();
        textView.setText(moduleNameById);
    }


}
