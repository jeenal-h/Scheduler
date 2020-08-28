package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText email;
    private Button reset_password, back;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        firebaseAuth = FirebaseAuth.getInstance();

        setupUIViews();
    }

    private void setupUIViews(){
        email = (EditText)findViewById(R.id.rsp_email);
        reset_password = (Button) findViewById(R.id.rsp_button);
        back = (Button) findViewById(R.id.rsp_button2);

        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User_email = email.getText().toString().trim();

                if(email.getText().toString().trim().length()==0){
                    email.setError("Please enter your registered email ID");
                    email.requestFocus();
                }
                else{
                    firebaseAuth.sendPasswordResetEmail(User_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetPassword.this,"Password reset email sent!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ResetPassword.this,Login.class));
                            }
                            else{
                                Toast.makeText(ResetPassword.this,"Error is sending password reset email :(",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResetPassword.this,Login.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
