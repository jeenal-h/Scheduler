package com.example.jeenal_h.scheduler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class ScheduleForTeachers extends AppCompatActivity {

    private EditText id;
    private EditText date;
    private EditText day;
    private EditText time;
    private EditText subject;
    private EditText topic;
    private EditText batch;
    private EditText branch;
    private Button add;
    private Button update;
    private Button delete;

    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_for_teachers);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseFirestore = FirebaseFirestore.getInstance();

        setupUIViews();
    }

    private void setupUIViews(){
        id = (EditText)findViewById(R.id.T_ID);
        date = (EditText)findViewById(R.id.T_Date);
        day = (EditText)findViewById(R.id.T_Day);
        time = (EditText)findViewById(R.id.T_Time);
        subject = (EditText)findViewById(R.id.T_Subject);
        topic = (EditText)findViewById(R.id.T_Topic);
        batch = (EditText)findViewById(R.id.T_Batch);
        branch = (EditText)findViewById(R.id.T_Branch);

        add = (Button)findViewById(R.id.T_AddSchedule);
        update = (Button)findViewById(R.id.T_UpdateSchedule);
        delete = (Button)findViewById(R.id.T_DeleteSchedule);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String tID = id.getText().toString();
                String tDate = date.getText().toString();
                String tDay = day.getText().toString();
                String tTime = time.getText().toString();
                String tSubject = subject.getText().toString();
                String tTopic = topic.getText().toString();
                String tBatch = batch.getText().toString();
                String tBranch = branch.getText().toString();

                Map<String,String> TS_Map = new HashMap<>();
                TS_Map.put("ID",tID);
                TS_Map.put("DATE",tDate);
                TS_Map.put("DAY",tDay);
                TS_Map.put("TIME",tTime);
                TS_Map.put("SUBJECT",tSubject);
                TS_Map.put("TOPIC",tTopic);
                TS_Map.put("BATCH",tBatch);
                TS_Map.put("BRANCH",tBranch);


                firebaseFirestore.collection("Schedule").document("Teacher")
                        .set(TS_Map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ScheduleForTeachers.this,"Schedule For Teacher with ID " +tID+ " Added",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(ScheduleForTeachers.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String tID = id.getText().toString();
                String tDate = date.getText().toString();
                String tDay = day.getText().toString();
                String tTime = time.getText().toString();
                String tSubject = subject.getText().toString();
                String tTopic = topic.getText().toString();
                String tBatch = batch.getText().toString();
                String tBranch = branch.getText().toString();

                Map<String,String> TS_Map = new HashMap<>();
                TS_Map.put("ID",tID);
                TS_Map.put("DATE",tDate);
                TS_Map.put("DAY",tDay);
                TS_Map.put("TIME",tTime);
                TS_Map.put("SUBJECT",tSubject);
                TS_Map.put("TOPIC",tTopic);
                TS_Map.put("BATCH",tBatch);
                TS_Map.put("BRANCH",tBranch);


                firebaseFirestore.collection("Schedule").document("Teacher")
                        .set(TS_Map, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ScheduleForTeachers.this,"Schedule For Teacher with ID " +tID+ " Updated",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(ScheduleForTeachers.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScheduleForTeachers.this, "Schedule will be deleted.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
