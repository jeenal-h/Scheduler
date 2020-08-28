package com.example.jeenal_h.scheduler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminLogin extends AppCompatActivity {

    private EditText edt1, edt2;
    private Button btn;
    private TextView tx1,tx2,tx3,tx4;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    FirebaseFirestore firebaseFirestore;

    final int[] counter = {3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        edt1 = (EditText)findViewById(R.id.L_User_ID);
        edt2 = (EditText)findViewById(R.id.L_Password);
        btn = (Button)findViewById(R.id.login);

        tx1 = (TextView)findViewById(R.id.Counter_tv);
        tx1.setVisibility(View.GONE);
        tx2 = (TextView)findViewById(R.id.Attempts_Left_tv);
        tx2.setVisibility(View.GONE);
        tx3 = (TextView)findViewById(R.id.tv_registration);
        tx4 = (TextView)findViewById(R.id.Forgot_password_tv);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(AdminLogin.this);

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

                if (user_email.equals("admin") &&
                       user_password.equals("admin")) {

                    Intent a = new Intent(AdminLogin.this, Admin.class);
                    //Intent is used to switch from one activity to another.

                    startActivity(a);
                    finish();

                    progressDialog.dismiss();

                    Toast.makeText(AdminLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(AdminLogin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
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
}
