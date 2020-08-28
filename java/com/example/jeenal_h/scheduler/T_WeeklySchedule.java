package com.example.jeenal_h.scheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

//import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;*/

public class T_WeeklySchedule extends AppCompatActivity {

    private EditText ID_No;
    private Button OK;
    //private TextView Teacher_Schedule;

    /*private FirebaseFirestore firebaseFirestore;
    private DocumentReference tRef = firebaseFirestore.document("Schedule/Teacher");*/

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__weekly_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ID_No = (EditText)findViewById(R.id.ID_No);
        OK = (Button)findViewById(R.id.t_OK);
        //Teacher_Schedule = (TextView)findViewById(R.id.Teacher_Schedule);

        //firebaseFirestore = FirebaseFirestore.getInstance();

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String IDno = ID_No.getText().toString();

                switch (IDno) {
                    case "01":
                        Toast.makeText(T_WeeklySchedule.this, "Loading Schedule of Teacher with ID 01", Toast.LENGTH_SHORT).show();
                        //loadTeacherSchedule();
                        //Teacher_Schedule.setText("Id: 01" + "\n" + "Date: 13-11-19" + "\n" + "Day: Monday" + "\n" + "Time: 5:30" + "\n" + "Subject: Android" + "\n" + "Topic: View Concept" + "\n" + "Batch: 01" + "\n" + "Branch: Thane");
                        break;
                    case "02":
                        Toast.makeText(T_WeeklySchedule.this, "Loading Schedule of Teacher with ID 02", Toast.LENGTH_SHORT).show();
                        //loadTeacherSchedule();
                        break;
                    case "03":
                        Toast.makeText(T_WeeklySchedule.this, "Loading Schedule of Teacher with ID 03", Toast.LENGTH_SHORT).show();
                        //loadTeacherSchedule();
                        break;
                    case "04":
                        Toast.makeText(T_WeeklySchedule.this, "Loading Schedule of Teacher with ID 04", Toast.LENGTH_SHORT).show();
                        //loadTeacherSchedule();
                        break;
                    default:
                        Toast.makeText(T_WeeklySchedule.this, "Please enter correct Batch No!", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }

    /*public void loadTeacherSchedule(){
        tRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String id = documentSnapshot.getString("ID");
                            String date = documentSnapshot.getString("DATE");
                            String day = documentSnapshot.getString("DAY");
                            String time = documentSnapshot.getString("TIME");
                            String subject = documentSnapshot.getString("SUBJECT");
                            String topic = documentSnapshot.getString("TOPIC");
                            String batch = documentSnapshot.getString("BATCH");
                            String branch = documentSnapshot.getString("BRANCH");

                            Teacher_Schedule.setText("Id: " + id + "\n" + "Date: " + date + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Subject: " + subject + "\n" + "Topic: " + topic + "\n" + "Batch: " + batch + "\n" + "Branch: " + branch);
                        }else{
                            Toast.makeText(T_WeeklySchedule.this, "Nothing Scheduled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(T_WeeklySchedule.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}

