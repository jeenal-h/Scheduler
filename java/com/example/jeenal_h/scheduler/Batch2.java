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

public class Batch2 extends AppCompatActivity {

    private EditText date;
    private EditText day;
    private EditText time;
    private EditText subject;
    private EditText topic;
    private EditText batch;
    private EditText teacher;
    private Button add;
    private Button update;
    private Button delete;

    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseFirestore = FirebaseFirestore.getInstance();

        setupUIViews();
    }

    private void setupUIViews(){
        date = (EditText)findViewById(R.id.B_Date);
        day = (EditText)findViewById(R.id.B_Day);
        time = (EditText)findViewById(R.id.B_Time);
        subject = (EditText)findViewById(R.id.B_Subject);
        topic = (EditText)findViewById(R.id.B_Topic);
        batch = (EditText)findViewById(R.id.B_Batch);
        teacher = (EditText)findViewById(R.id.B_Teacher);

        add = (Button)findViewById(R.id.B_AddSchedule);
        update = (Button)findViewById(R.id.B_UpdateSchedule);
        delete = (Button)findViewById(R.id.B_DeleteSchedule);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tDate = date.getText().toString();
                String tDay = day.getText().toString();
                String tTime = time.getText().toString();
                String tSubject = subject.getText().toString();
                String tTopic = topic.getText().toString();
                final String tBatch = batch.getText().toString();
                String tTeacher = teacher.getText().toString();

                Map<String,String> SS_Map = new HashMap<>();
                SS_Map.put("DATE",tDate);
                SS_Map.put("DAY",tDay);
                SS_Map.put("TIME",tTime);
                SS_Map.put("SUBJECT",tSubject);
                SS_Map.put("TOPIC",tTopic);
                SS_Map.put("BATCH",tBatch);
                SS_Map.put("TEACHER",tTeacher);


                firebaseFirestore.collection("Schedule").document("Batch2")
                        .set(SS_Map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Batch2.this,"Schedule For Batch " +tBatch+ " Added",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(Batch2.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tDate = date.getText().toString();
                String tDay = day.getText().toString();
                String tTime = time.getText().toString();
                String tSubject = subject.getText().toString();
                String tTopic = topic.getText().toString();
                final String tBatch = batch.getText().toString();
                String tTeacher = teacher.getText().toString();

                Map<String,String> SS_Map = new HashMap<>();
                SS_Map.put("DATE",tDate);
                SS_Map.put("DAY",tDay);
                SS_Map.put("TIME",tTime);
                SS_Map.put("SUBJECT",tSubject);
                SS_Map.put("TOPIC",tTopic);
                SS_Map.put("BATCH",tBatch);
                SS_Map.put("TEACHER",tTeacher);


                firebaseFirestore.collection("Schedule").document("Batch2")
                        .set(SS_Map, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Batch2.this,"Schedule For Batch " +tBatch+ " Updated",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(Batch2.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Batch2.this, "Schedule will be deleted.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
