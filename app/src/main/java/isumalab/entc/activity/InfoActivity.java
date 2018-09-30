package isumalab.entc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import isumalab.entc.R;

public class InfoActivity extends AppCompatActivity {

  private Toolbar toolbar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);

    TextView note = (TextView) findViewById(R.id.news);

    //adding toolbar
    toolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    DatabaseReference ref;
    ref = FirebaseDatabase.getInstance().getReference("news");

    ref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        String news = dataSnapshot.getValue(String.class);
        note.setText(news);
      }
      @Override
      public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
      }
    });


  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if(item.getItemId()== android.R.id.home) {

      finish();
    }
    return super.onOptionsItemSelected(item);
  }


}
