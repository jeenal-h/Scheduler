package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {

    private Toolbar toolbar;
    private CardView cd1,cd2,cd3,cd4;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        setupUIViews();
        initCards();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        cd1=(CardView)findViewById(R.id.CardView1);
        cd2=(CardView)findViewById(R.id.CardView2);
        cd3=(CardView)findViewById(R.id.CardView3);
        cd4=(CardView)findViewById(R.id.CardView4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_LONG).show();
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Admin.this,Login.class));
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initCards() {

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this,
                        StudentDetails.class));
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this,
                        TeacherDetails.class));
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this,
                        Schedule.class));

            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin.this,
                        AdminNotes.class));

            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
