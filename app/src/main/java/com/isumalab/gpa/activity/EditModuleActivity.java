package com.isumalab.gpa.activity;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.isumalab.gpa.R;
import com.isumalab.gpa.entity.ModuleEntity;
import com.isumalab.gpa.utils.ModuleViewModel;

public class EditModuleActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final String MODULE_NAME = "name";
    public static final String MODULE_CODE = "code";
    public static final String MODULE_GPA = "gpa";
    public static final String MODULE_CREDIT = "credit";
    public static final String MODULE_SCORE = "score";

    private ModuleViewModel mModuleViewModel;

    private EditText EditModuleView_MouduleCode;
    private EditText EditModuleView_MouduleName;
    private EditText EditModuleView_MouduleCredit;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton rb1;
    private RadioButton rb2;
    private Spinner spinner2;

    private String moduleName;
    private String moduleCode;
    private boolean gpa;
    private double credit;
    private double score;
    private int id;
    private int semNo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mModuleViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);

        setContentView(R.layout.activity_edit_module);
        EditModuleView_MouduleName = findViewById(R.id.edit_module_name);
        EditModuleView_MouduleCode = findViewById(R.id.edit_module_code);
        EditModuleView_MouduleCredit = findViewById(R.id.et_credit);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        spinner2 = findViewById(R.id.spinner2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        moduleName = extras.getString("name");
        moduleCode =  extras.getString("code");
        gpa = extras.getBoolean("gpa");
        credit = Double.parseDouble(String.valueOf(extras.getFloat("credit")));
        score = Double.parseDouble(String.valueOf(extras.getFloat("score")));
        id = extras.getInt("id");
        semNo = extras.getInt("semNo");

        EditModuleView_MouduleName.setText(moduleName);
        EditModuleView_MouduleCode.setText(moduleCode);
        radioGroup.check(getRadioButtonID(gpa));
        EditModuleView_MouduleCredit.setText(String.valueOf(credit));
        spinner2.setSelection(getGradePosition(score));

        final Button button = findViewById(R.id.button_edit_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String spinner1_result = EditModuleView_MouduleCredit.getText().toString();
                String spinner2_result = spinner2.getSelectedItem().toString();
                if (TextUtils.isEmpty(EditModuleView_MouduleName.getText()) || TextUtils.isEmpty(EditModuleView_MouduleCode.getText()) || (selectedId == -1) || TextUtils.isEmpty(EditModuleView_MouduleCredit.getText()) || spinner2_result.isEmpty()) {
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.edit_save_msg,
                            Toast.LENGTH_LONG).show();
                } else {
                    radioButton = findViewById(selectedId);
                    String name = EditModuleView_MouduleName.getText().toString();
                    String code = EditModuleView_MouduleCode.getText().toString();
                    String credit = EditModuleView_MouduleCredit.getText().toString();
                    String gpa_updated = (String) radioButton.getText();

                    ModuleEntity moduleEntity = new ModuleEntity();
                    moduleEntity.setId(id);
                    moduleEntity.setActive(true);
                    moduleEntity.setCredit(Double.parseDouble(credit));
                    moduleEntity.setGpa(getStrBool(gpa_updated));
                    moduleEntity.setModule_name(name);
                    moduleEntity.setModule_code(code);
                    moduleEntity.setSemester_no(semNo);
                    moduleEntity.setScore(Double.parseDouble(getGrade(spinner2_result)));

                    try{
                       mModuleViewModel.insert(moduleEntity);
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.module_update,
                                Toast.LENGTH_LONG).show();
                        finish();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

        final Button button_del = findViewById(R.id.button_del);
        button_del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(EditModuleView_MouduleName.getText()) || TextUtils.isEmpty(EditModuleView_MouduleCode.getText())) {

                } else {
                    String name = EditModuleView_MouduleName.getText().toString();
                    String code = EditModuleView_MouduleCode.getText().toString();

                    ModuleEntity moduleEntity = new ModuleEntity();
                    moduleEntity.setId(id);
                    moduleEntity.setActive(true);
                    moduleEntity.setCredit(credit);
                    moduleEntity.setGpa(gpa);
                    moduleEntity.setModule_name(name);
                    moduleEntity.setModule_code(code);
                    moduleEntity.setSemester_no(semNo);
                    moduleEntity.setScore(score);

                    try{
                        mModuleViewModel.delete(moduleEntity);
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.module_delete,
                                Toast.LENGTH_LONG).show();
                        finish();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    public int getRadioButtonID(boolean gpa){
        if (gpa){
            return rb1.getId();
        }else{
            return rb2.getId();
        }
    }

    public boolean getStrBool(String s) {
        if (s.equals("Yes")) {
            return true;
        } else if (s.equals("No")) {
            return false;
        }
        return false;
    }

    public String getGrade(String s) {
        if (s.equals("A+")) {
            return "4.2";
        } else if (s.equals("A")) {
            return "4.0";
        }else if (s.equals("A-")) {
            return "3.7";
        }else if (s.equals("B+")) {
            return "3.3";
        }else if (s.equals("B")) {
            return "3.0";
        }else if (s.equals("B-")) {
            return "2.7";
        }else if (s.equals("C+")) {
            return "2.3";
        }else if (s.equals("C")) {
            return "2.0";
        }else if (s.equals("C-")) {
            return "1.5";
        }else if (s.equals("D")) {
            return "1.0";
        }else if (s.equals("F")) {
            return "0.0";
        }
        return "0.0";
    }

    public int getGradePosition(double grade){
        if (grade==4.2){
            return 0;
        }else if(grade==4.0){
            return 1;
        }else if(grade==3.7){
            return 2;
        }else if(grade==3.3){
            return 3;
        }else if(grade==3.0){
            return 4;
        }else if(grade==2.7){
            return 5;
        }else if(grade==2.3){
            return 6;
        }else if(grade==2.0){
            return 7;
        }else if(grade==1.5){
            return 8;
        }else if(grade==1.0){
            return 9;
        }else if(grade==0){
            return 10;
        }
        return 10;
    }


}

