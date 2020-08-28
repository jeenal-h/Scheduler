package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TeacherDetails extends AppCompatActivity {

    private Toolbar toolbar;
    private CardView cd1,cd2,cd3,cd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_details);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


    private void initCards() {

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherDetails.this,
                        AddTeacher.class));
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherDetails.this,
                        DeleteTeacher.class));
            }
        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherDetails.this,
                        UpdateTeacher.class));

            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherDetails.this,
                        TeacherDatabase.class));

            }
        });
    }

}
