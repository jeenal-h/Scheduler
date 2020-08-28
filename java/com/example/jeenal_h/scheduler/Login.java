package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

private EditText user_type;
private Button OK;
private TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUIViews();
    }

    private void setupUIViews(){
        user_type = (EditText)findViewById(R.id.L_UserType);
        OK = (Button)findViewById(R.id.L_Button);
        tv = (TextView)findViewById(R.id.tv_registration);

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String UserType = user_type.getText().toString();
                switch (UserType) {
                    case "admin":
                        startActivity(new Intent(Login.this,
                                AdminLogin.class));
                        break;
                    case "01":
                        startActivity(new Intent(Login.this,
                                StudentLogin.class));
                        break;
                    case "02":
                        startActivity(new Intent(Login.this,
                                TeacherLogin.class));
                        break;
                    default:
                        Toast.makeText(Login.this, "Please enter correct type!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
