package com.isumalab.gpa.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.isumalab.gpa.R;
import com.isumalab.gpa.entity.ModuleEntity;
import com.isumalab.gpa.services.Calculation;
import com.isumalab.gpa.utils.ModuleViewModel;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TextView textViewOverAllGpa;
    private TextView textViewGpaSem1;
    private TextView textViewGpaSem2;
    private TextView textViewGpaSem3;
    private TextView textViewGpaSem4;
    private TextView textViewGpaSem5;
    private TextView textViewGpaSem6;
    private TextView textViewGpaSem7;
    private TextView textViewGpaSem8;


    private ModuleViewModel mModuleViewModel;
    private List<ModuleEntity> mModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        textViewOverAllGpa = findViewById(R.id.tw_overall_gpa);
        textViewGpaSem1 = findViewById(R.id.tw_sem1);
        textViewGpaSem2 = findViewById(R.id.tw_sem2);
        textViewGpaSem3 = findViewById(R.id.tw_sem3);
        textViewGpaSem4 = findViewById(R.id.tw_sem4);
        textViewGpaSem5 = findViewById(R.id.tw_sem5);
        textViewGpaSem6 = findViewById(R.id.tw_sem6);
        textViewGpaSem7 = findViewById(R.id.tw_sem7);
        textViewGpaSem8 = findViewById(R.id.tw_sem8);

        ModuleViewModel moduleViewModel = new ModuleViewModel(getApplication());
        textViewOverAllGpa.setText(String.valueOf(moduleViewModel.getOverallGpa()));
        textViewGpaSem1.setText(String.valueOf(moduleViewModel.getGpaSem1()));
        textViewGpaSem2.setText(String.valueOf(moduleViewModel.getGpaSem2()));
        textViewGpaSem3.setText(String.valueOf(moduleViewModel.getGpaSem3()));
        textViewGpaSem4.setText(String.valueOf(moduleViewModel.getGpaSem4()));
        textViewGpaSem5.setText(String.valueOf(moduleViewModel.getGpaSem5()));
        textViewGpaSem6.setText(String.valueOf(moduleViewModel.getGpaSem6()));
        textViewGpaSem7.setText(String.valueOf(moduleViewModel.getGpaSem7()));
        textViewGpaSem8.setText(String.valueOf(moduleViewModel.getGpaSem8()));

//        final Button button = findViewById(R.id.button_refresh);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Calculation calculation = new Calculation();
//                calculation.OverAllGpa();
//            }
//        });

        ImageView imageViewRefresh = (ImageView) findViewById(R.id.img_refresh);
        imageViewRefresh.setClickable(true);
        imageViewRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation calculation = new Calculation();
                calculation.init(getApplication());
            }
        });


        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);



        mModuleViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);

        mModuleViewModel.getOverallGpa().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewOverAllGpa.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem1().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem1.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem2().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem2.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem3().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem3.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem4().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem4.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem5().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem5.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem6().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem6.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem7().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem7.setText(String.valueOf(gpa));
            }
        });

        mModuleViewModel.getGpaSem8().observe(this,new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double gpa) {
                textViewGpaSem8.setText(String.valueOf(gpa));
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.edit_sem1);
        imageView1.setClickable(true);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterOneActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView2 = (ImageView) findViewById(R.id.edit_sem2);
        imageView2.setClickable(true);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterTwoActivity.class);
                startActivity(i);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.edit_sem3);
        imageView3.setClickable(true);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterThreeActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView4 = (ImageView) findViewById(R.id.edit_sem4);
        imageView4.setClickable(true);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterFourActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView5 = (ImageView) findViewById(R.id.edit_sem5);
        imageView5.setClickable(true);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterFiveActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView6 = (ImageView) findViewById(R.id.edit_sem6);
        imageView6.setClickable(true);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterSixActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView7 = (ImageView) findViewById(R.id.edit_sem7);
        imageView7.setClickable(true);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterSevenActivity.class);
                startActivity(i);
            }
        });

        ImageView imageView8 = (ImageView) findViewById(R.id.edit_sem8);
        imageView8.setClickable(true);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SemesterEightActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
//            Toast.makeText(MainActivity.this, "Action : Search clicked", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, InfoActivity.class);
            this.startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getItemCount() {
        if (mModules != null) {
            System.out.println(mModules.size());
            return mModules.size();
        }else return 0;
    }
}
