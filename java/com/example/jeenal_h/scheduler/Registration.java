package com.example.jeenal_h.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    private Button btn1,btn2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setupUIViews();
        initCards();
    }

    private void setupUIViews(){
        btn1=(Button)findViewById(R.id.s_register);
        btn2=(Button)findViewById(R.id.t_register);
        tv = (TextView) findViewById(R.id.tv_to_login_page);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,Login.class));
            }
        });

    }

    private void initCards() {

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,
                        StudentRegister.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,
                        TeacherRegister.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
