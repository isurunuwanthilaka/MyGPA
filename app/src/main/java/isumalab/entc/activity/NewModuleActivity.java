package isumalab.entc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;

public class NewModuleActivity extends AppCompatActivity {

  public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
  public static final String MODULE_NAME = "name";
  public static final String MODULE_CODE = "code";
  public static final String MODULE_GPA = "gpa";
  public static final String MODULE_CREDIT = "credit";
  public static final String MODULE_SCORE = "score";

  private EditText EditModuleView_MouduleCode;
  private EditText EditModuleView_MouduleName;
  private EditText EditModuleView_MouduleCredit;
  private RadioGroup radioGroup;
  private RadioButton radioButton;
  private Spinner spinner2;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_module);
    EditModuleView_MouduleName = findViewById(R.id.edit_module_name);
    EditModuleView_MouduleCode = findViewById(R.id.edit_module_code);
    EditModuleView_MouduleCredit = findViewById(R.id.et_credit);
    radioGroup = findViewById(R.id.radioGroup);
    spinner2 = findViewById(R.id.spinner2);

    final Button button = findViewById(R.id.button_save);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        Intent replyIntent = new Intent();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String spinner1_result = EditModuleView_MouduleCredit.getText().toString();
        String spinner2_result = spinner2.getSelectedItem().toString();
        if (TextUtils.isEmpty(EditModuleView_MouduleName.getText())||TextUtils.isEmpty(EditModuleView_MouduleCode.getText())||(selectedId==-1)||TextUtils.isEmpty(EditModuleView_MouduleCredit.getText())||spinner2_result.isEmpty()){
          setResult(RESULT_CANCELED, replyIntent);
        } else {

          radioButton =findViewById(selectedId);

          String name = EditModuleView_MouduleName.getText().toString();
          String code = EditModuleView_MouduleCode.getText().toString();
          String gpa = (String)radioButton.getText();
          replyIntent.putExtra(MODULE_NAME,name);
          replyIntent.putExtra(MODULE_CODE,code);
          replyIntent.putExtra(MODULE_GPA,getStrBool(gpa));
          replyIntent.putExtra(MODULE_CREDIT,spinner1_result);
          replyIntent.putExtra(MODULE_SCORE,getGrade(spinner2_result));
          setResult(RESULT_OK, replyIntent);
        }
        finish();
      }
    });
  }

  public String getStrBool(String s){
    if (s.equals("Yes")){
      return "true";
    }else if(s.equals("No")){
      return "false";
    }
    return "false";
  }

  public String getGrade(String s){
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
}

