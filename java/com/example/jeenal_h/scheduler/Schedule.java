package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Schedule extends AppCompatActivity {

    private Toolbar toolbar;
    private CardView cd1,cd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupUIViews();
        initCards();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        cd1=(CardView)findViewById(R.id.CardView1);
        cd2=(CardView)findViewById(R.id.CardView2);
    }

    private void initCards() {

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Schedule.this,
                        ScheduleForStudents.class));
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Schedule.this,
                        ScheduleForTeachers.class));
            }
        });

    }

}
