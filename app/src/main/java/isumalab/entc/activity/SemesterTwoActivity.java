package isumalab.entc.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;
import isumalab.entc.utils.ModuleListAdapter;
import isumalab.entc.utils.ModuleViewModel;


public class SemesterTwoActivity extends AppCompatActivity {

    public static final int NEW_MODULE_ACTIVITY_REQUEST_CODE = 1;

    private ModuleViewModel mModuleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ModuleListAdapter adapter = new ModuleListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mModuleViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mModuleViewModel.getSemTwoModules().observe(this, new Observer<List<ModuleEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ModuleEntity> modules) {
                // Update the cached copy of the words in the adapter.
                adapter.setModules(modules);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SemesterTwoActivity.this, NewModuleActivity.class);
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
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_MODULE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            ModuleEntity moduleEntity = new ModuleEntity();
            moduleEntity.setModule_name(data.getStringExtra(NewModuleActivity.EXTRA_REPLY));
            moduleEntity.setCredit(3);
            moduleEntity.setSemester_no(2);
            moduleEntity.setModule_code("en0001");
//            moduleEntity.setId(1);
            moduleEntity.setActive(true);
            moduleEntity.setScore(1);
            moduleEntity.setGpa(true);
            mModuleViewModel.insert(moduleEntity);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
