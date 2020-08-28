package com.example.jeenal_h.scheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;*/

public class S_WeeklySchedule extends AppCompatActivity {

    private EditText Batch_No;
    private Button OK;
    //private TextView Batch_Schedule;

    /*private FirebaseFirestore firebaseFirestore;
    private DocumentReference b1Ref = firebaseFirestore.document("Schedule/Batch1");
    private DocumentReference b2Ref = firebaseFirestore.document("Schedule/Batch2");
    private DocumentReference b3Ref = firebaseFirestore.document("Schedule/Batch3");
    private DocumentReference b4Ref = firebaseFirestore.document("Schedule/Batch4");*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s__weekly_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Batch_No = (EditText)findViewById(R.id.Batch_No);
        OK = (Button)findViewById(R.id.s_OK);
        //Batch_Schedule = (TextView)findViewById(R.id.Batch_Schedule);

        //firebaseFirestore = FirebaseFirestore.getInstance();

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String BatchNo = Batch_No.getText().toString();

                switch (BatchNo) {
                    case "01":
                        Toast.makeText(S_WeeklySchedule.this, "Loading Batch1 Schedule", Toast.LENGTH_SHORT).show();
                        //loadBatch1Schedule();
                        break;
                    case "02":
                        Toast.makeText(S_WeeklySchedule.this, "Loading Batch2 Schedule", Toast.LENGTH_SHORT).show();
                        //loadBatch2Schedule();
                        break;
                    case "03":
                        Toast.makeText(S_WeeklySchedule.this, "Loading Batch3 Schedule", Toast.LENGTH_SHORT).show();
                        //loadBatch3Schedule();
                        break;
                    case "04":
                        Toast.makeText(S_WeeklySchedule.this, "Loading Batch4 Schedule", Toast.LENGTH_SHORT).show();
                        //loadBatch4Schedule();
                        break;
                    default:
                        Toast.makeText(S_WeeklySchedule.this, "Please enter correct Batch No!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    /*public void loadBatch1Schedule(){
        b1Ref.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String date = documentSnapshot.getString("DATE");
                            String day = documentSnapshot.getString("DAY");
                            String time = documentSnapshot.getString("TIME");
                            String subject = documentSnapshot.getString("SUBJECT");
                            String topic = documentSnapshot.getString("TOPIC");
                            String batch = documentSnapshot.getString("BATCH");
                            String teacher = documentSnapshot.getString("TEACHER");

                            Batch_Schedule.setText("Date: " + date + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Subject: " + subject + "\n" + "Topic: " + topic + "\n" + "Batch: " + batch + "\n" + "Teacher: " + teacher);
                        }else{
                            Toast.makeText(S_WeeklySchedule.this, "Nothing Scheduled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(S_WeeklySchedule.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadBatch2Schedule(){
        b2Ref.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String date = documentSnapshot.getString("DATE");
                            String day = documentSnapshot.getString("DAY");
                            String time = documentSnapshot.getString("TIME");
                            String subject = documentSnapshot.getString("SUBJECT");
                            String topic = documentSnapshot.getString("TOPIC");
                            String batch = documentSnapshot.getString("BATCH");
                            String teacher = documentSnapshot.getString("TEACHER");

                            Batch_Schedule.setText("Date: " + date + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Subject: " + subject + "\n" + "Topic: " + topic + "\n" + "Batch: " + batch + "\n" + "Teacher: " + teacher);
                        }else{
                            Toast.makeText(S_WeeklySchedule.this, "Nothing Scheduled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(S_WeeklySchedule.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadBatch3Schedule(){
        b3Ref.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String date = documentSnapshot.getString("DATE");
                            String day = documentSnapshot.getString("DAY");
                            String time = documentSnapshot.getString("TIME");
                            String subject = documentSnapshot.getString("SUBJECT");
                            String topic = documentSnapshot.getString("TOPIC");
                            String batch = documentSnapshot.getString("BATCH");
                            String teacher = documentSnapshot.getString("TEACHER");

                            Batch_Schedule.setText("Date: " + date + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Subject: " + subject + "\n" + "Topic: " + topic + "\n" + "Batch: " + batch + "\n" + "Teacher: " + teacher);
                        }else{
                            Toast.makeText(S_WeeklySchedule.this, "Nothing Scheduled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(S_WeeklySchedule.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadBatch4Schedule(){
        b4Ref.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String date = documentSnapshot.getString("DATE");
                            String day = documentSnapshot.getString("DAY");
                            String time = documentSnapshot.getString("TIME");
                            String subject = documentSnapshot.getString("SUBJECT");
                            String topic = documentSnapshot.getString("TOPIC");
                            String batch = documentSnapshot.getString("BATCH");
                            String teacher = documentSnapshot.getString("TEACHER");

                            Batch_Schedule.setText("Date: " + date + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Subject: " + subject + "\n" + "Topic: " + topic + "\n" + "Batch: " + batch + "\n" + "Teacher: " + teacher);
                        }else{
                            Toast.makeText(S_WeeklySchedule.this, "Nothing Scheduled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(S_WeeklySchedule.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
