package isumalab.entc.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;
import isumalab.entc.utils.ModuleRepository;
import isumalab.entc.utils.ModuleViewModel;

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
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton rb1;
    private RadioButton rb2;
    private Spinner spinner1;
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
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        spinner1 = findViewById(R.id.spinner1);
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
        rb1.setSelected(gpa);
        spinner1.setSelection(getGradePosition(credit));
        spinner2.setSelection(getGradePosition(score));

        final Button button = findViewById(R.id.button_edit_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String spinner1_result = spinner1.getSelectedItem().toString();
                String spinner2_result = spinner2.getSelectedItem().toString();
                if (TextUtils.isEmpty(EditModuleView_MouduleName.getText()) || TextUtils.isEmpty(EditModuleView_MouduleCode.getText()) || (selectedId == -1) || spinner1_result.isEmpty() || spinner2_result.isEmpty()) {
                } else {
                    radioButton = findViewById(selectedId);
                    String name = EditModuleView_MouduleName.getText().toString();
                    String code = EditModuleView_MouduleCode.getText().toString();
                    String gpa_updated = (String) radioButton.getText();

                    ModuleEntity moduleEntity = new ModuleEntity();
                    moduleEntity.setId(id);
                    moduleEntity.setActive(true);
                    moduleEntity.setCredit(Double.parseDouble(getGrade(spinner1_result)));
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
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

        final Button button_del = findViewById(R.id.button_del);
        button_del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String spinner1_result = spinner1.getSelectedItem().toString();
                String spinner2_result = spinner2.getSelectedItem().toString();
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
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });
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
        }
        return "0.0";
    }

    public int getGradePosition(double grade){
        if (grade==4.2){
            return 1;
        }else if(grade==4.0){
            return 2;
        }
        return 3;
    }


}

