package com.example.jeenal_h.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentDatabase extends AppCompatActivity {

    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_database);

        setupUIViews();
    }

    private void setupUIViews() {
        btn = (Button)findViewById(R.id.s_database);
        tv = (TextView)findViewById(R.id.s_loading);

        tv.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.VISIBLE);
            }
        });
    }


}
