package com.example.jeenal_h.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class TeacherRegister extends AppCompatActivity {

    private EditText t_name;
    private EditText t_designation;
    private EditText t_mobile;
    private EditText t_email;
    private EditText t_password;
    private EditText t_type;
    private Button t_button;
    private TextView tv;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        setupUIViews();
    }

    private void setupUIViews() {

        t_name = (EditText)findViewById(R.id.t_name);
        t_designation = (EditText)findViewById(R.id.t_designation);
        t_mobile = (EditText)findViewById(R.id.t_mobile);
        t_email = (EditText)findViewById(R.id.t_email);
        t_password = (EditText)findViewById(R.id.t_password);
        t_type = (EditText)findViewById(R.id.t_type);
        t_button = (Button)findViewById(R.id.t_register);

        tv = (TextView)findViewById(R.id.tv_to_login_page);

        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tName = t_name.getText().toString();
                String tClass = t_designation.getText().toString();
                String tMobile = t_mobile.getText().toString();
                String tEmail = t_email.getText().toString();
                String tType = t_type.getText().toString();

                Map<String,String> userMap = new HashMap<>();
                userMap.put("NAME",tName);
                userMap.put("DESIGNATION",tClass);
                userMap.put("MOBILE",tMobile);
                userMap.put("EMAIL",tEmail);
                userMap.put("TYPE",tType);

                firebaseFirestore.collection("Users").document("Details")
                        .set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(TeacherRegister.this,"Your details are recorded",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(TeacherRegister.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

                String T_name = t_name.getText().toString();
                String T_designation = t_designation.getText().toString();
                String T_mobile = t_mobile.getText().toString();
                String T_email = t_email.getText().toString();
                String T_password = t_password.getText().toString();
                String T_type = t_type.getText().toString();


                if(T_name.isEmpty() || T_designation.isEmpty() || T_mobile.isEmpty() || T_email.isEmpty() || T_type.isEmpty()){
                    Toast.makeText(TeacherRegister.this,"Please enter all the details",Toast.LENGTH_SHORT).show();
                }
                else if(T_password.length()<8){
                    Toast.makeText(TeacherRegister.this,"Password should be greater than or equal to 8 characters",Toast.LENGTH_SHORT).show();
                }
                else if(T_mobile.length()<10){
                    Toast.makeText(TeacherRegister.this,"Mobile number should be of minimum 10 digits",Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.createUserWithEmailAndPassword(T_email, T_password)
                            .addOnCompleteListener(TeacherRegister.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(TeacherRegister.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                                        onBackPressed();
                                    }
                                    else{
                                        Toast.makeText(TeacherRegister.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                                        onBackPressed();
                                    }
                                }
                            });
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherRegister.this,Login.class));
            }
        });

    }

}
