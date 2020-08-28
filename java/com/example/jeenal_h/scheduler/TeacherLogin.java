package com.example.jeenal_h.scheduler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class TeacherLogin extends AppCompatActivity {

    private EditText edt1, edt2;
    private Button btn;
    private TextView tx1,tx2,tx3;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    FirebaseFirestore firebaseFirestore;

    final int[] counter = {3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        edt1 = (EditText)findViewById(R.id.L_User_ID);
        edt2 = (EditText)findViewById(R.id.L_Password);
        btn = (Button)findViewById(R.id.login);

        tx1 = (TextView)findViewById(R.id.Counter_tv);
        tx1.setVisibility(View.GONE);
        tx2 = (TextView)findViewById(R.id.Attempts_Left_tv);
        tx2.setVisibility(View.GONE);
        tx3 = (TextView)findViewById(R.id.Forgot_password_tv);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(TeacherLogin.this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email = edt1.getText().toString();
                String user_password = edt2.getText().toString();

                if (edt1.getText().toString().trim().length() == 0) {
                    edt1.setError("User ID is not entered");
                    edt1.requestFocus();
                }
                if (edt2.getText().toString().trim().length() == 0) {
                    edt2.setError("Password is not entered");
                    edt2.requestFocus();
                } else {
                    validate(user_email, user_password);
                }

            }

            private void validate(final String user_email, final String user_password){
                progressDialog.setTitle("Please Wait");
                progressDialog.setMessage("Redirecting...");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(user_email, user_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();

                                    Toast.makeText(TeacherLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(TeacherLogin.this, Teacher.class));
                                    finish();
                                } else {
                                    Toast.makeText(TeacherLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                    tx1.setVisibility(View.VISIBLE);
                                    tx1.setTextColor(Color.RED);
                                    tx1.setBackgroundColor(Color.WHITE);
                                    tx2.setVisibility(View.VISIBLE);
                                    tx2.setBackgroundColor(Color.WHITE);
                                    counter[0]--;
                                    progressDialog.dismiss();

                                    tx1.setText(Integer.toString(counter[0]));

                                    if (counter[0] == 0) {
                                        btn.setEnabled(false);
                                    }
                                }
                            }
                        });


            }

        });

        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherLogin.this, ResetPassword.class));
                finish();
            }
        });

    }
}
