package com.example.jeenal_h.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddStudent extends AppCompatActivity {

    private EditText s_name;
    private EditText s_class;
    private EditText s_mobile;
    private EditText s_email;
    private EditText s_password;
    private EditText s_type;
    private Button s_button;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        setupUIViews();
    }

    private void setupUIViews() {
        s_name = (EditText) findViewById(R.id.s_name);
        s_class = (EditText) findViewById(R.id.s_class);
        s_mobile = (EditText) findViewById(R.id.s_mobile);
        s_email = (EditText) findViewById(R.id.s_email);
        s_password = (EditText) findViewById(R.id.s_password);
        s_type = (EditText) findViewById(R.id.s_type);
        s_button = (Button) findViewById(R.id.s_register);


        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sName = s_name.getText().toString();
                String sClass = s_class.getText().toString();
                String sMobile = s_mobile.getText().toString();
                String sEmail = s_email.getText().toString();
                String sType = s_type.getText().toString();

                Map<String, String> userMap = new HashMap<>();
                userMap.put("NAME", sName);
                userMap.put("CLASS", sClass);
                userMap.put("MOBILE", sMobile);
                userMap.put("EMAIL", sEmail);
                userMap.put("TYPE", sType);


                firebaseFirestore.collection("Users").document("Details")
                        .set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddStudent.this, "Student Details Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(AddStudent.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                    }
                });

                String S_name = s_name.getText().toString();
                String S_class = s_class.getText().toString();
                String S_mobile = s_mobile.getText().toString();
                String S_email = s_email.getText().toString();
                String S_password = s_password.getText().toString();
                String S_type = s_type.getText().toString();


                if (S_name.isEmpty() || S_class.isEmpty() || S_mobile.isEmpty() || S_email.isEmpty() || S_password.isEmpty() || S_type.isEmpty()) {
                    Toast.makeText(AddStudent.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                } else if (S_password.length() < 8) {
                    Toast.makeText(AddStudent.this, "Password should be greater than or equal to 8 characters", Toast.LENGTH_SHORT).show();
                } else if (S_mobile.length() < 10) {
                    Toast.makeText(AddStudent.this, "Mobile number should be of minimum 10 digits", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(S_email, S_password)
                            .addOnCompleteListener(AddStudent.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AddStudent.this, "Student Registered Successfully", Toast.LENGTH_SHORT).show();
                                        onBackPressed();
                                    } else {
                                        Toast.makeText(AddStudent.this, "Error Registering Student", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

}
