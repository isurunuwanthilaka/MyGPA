package isumalab.entc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import isumalab.entc.R;
import isumalab.entc.entity.ModuleEntity;

public class NewModuleActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final String MODULE_NAME = "name";
    public static final String MODULE_CODE = "code";

    private EditText EditModuleView_MouduleCode;
    private EditText EditModuleView_MouduleName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_module);
        EditModuleView_MouduleName = findViewById(R.id.edit_module_name);
        EditModuleView_MouduleCode = findViewById(R.id.edit_module_code);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(EditModuleView_MouduleName.getText())||TextUtils.isEmpty(EditModuleView_MouduleCode.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = EditModuleView_MouduleName.getText().toString();
                    String code = EditModuleView_MouduleCode.getText().toString();
                    replyIntent.putExtra(MODULE_NAME,name);
                    replyIntent.putExtra(MODULE_CODE,code);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}

