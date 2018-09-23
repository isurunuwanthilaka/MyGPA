package isumalab.entc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import isumalab.entc.R;
public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

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
}
