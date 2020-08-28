package com.example.jeenal_h.scheduler;

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
import com.google.firebase.auth.FirebaseUser;

public class DeleteTeacher extends AppCompatActivity {

    private EditText email;
    private Button btn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_teacher);

        firebaseAuth = FirebaseAuth.getInstance();
        setupUIViews();
    }

    private void setupUIViews() {
        email = (EditText)findViewById(R.id.dt_email);
        btn = (Button) findViewById(R.id.dt_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // deleteTeacher();
                Toast.makeText(DeleteTeacher.this, "Teacher deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

   /* private void deleteTeacher(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String d_email = email.getText().toString();

        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DeleteTeacher.this, "Teacher deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    } */

}
