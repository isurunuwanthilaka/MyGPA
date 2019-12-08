package com.isumalab.gpa.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import com.isumalab.gpa.R;
import com.isumalab.gpa.entity.ModuleEntity;
import com.isumalab.gpa.utils.ModuleListAdapter;
import com.isumalab.gpa.utils.ModuleViewModel;


public class SemesterSevenActivity extends AppCompatActivity {

    public static final int NEW_MODULE_ACTIVITY_REQUEST_CODE = 1;
    public static final int SEMESTER_NO = 7;

    private ModuleViewModel mModuleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ModuleListAdapter adapter = new ModuleListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mModuleViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);
        mModuleViewModel.getSemSevenModules().observe(this, new Observer<List<ModuleEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ModuleEntity> modules) {
                // Update the cached copy of the List<ModuleEntity> in the adapter.
                adapter.setModules(modules);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SemesterSevenActivity.this, NewModuleActivity.class);
                startActivityForResult(intent, NEW_MODULE_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();
        }
        if (id == R.id.action_info) {
            Toast.makeText(this, "Semester 7", Toast.LENGTH_LONG).show();
//            Intent i = new Intent(this, InfoActivity.class);
//            this.startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_MODULE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            ModuleEntity moduleEntity = new ModuleEntity();
            moduleEntity.setModule_name(data.getStringExtra(NewModuleActivity.MODULE_NAME));
            moduleEntity.setModule_code(data.getStringExtra(NewModuleActivity.MODULE_CODE));
            moduleEntity.setGpa(Boolean.parseBoolean(data.getStringExtra(NewModuleActivity.MODULE_GPA)));
            moduleEntity.setCredit(Double.parseDouble(data.getStringExtra(NewModuleActivity.MODULE_CREDIT)));
            moduleEntity.setScore(Double.parseDouble(data.getStringExtra(NewModuleActivity.MODULE_SCORE)));
            moduleEntity.setSemester_no(SEMESTER_NO);
            moduleEntity.setActive(true);
            mModuleViewModel.insert(moduleEntity);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
